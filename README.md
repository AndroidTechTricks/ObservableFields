# ObservableFields

## What is ObservableFields and why to use ?
- An ObservableField is a class provided by the Android Data Binding library. It is used to create observable fields that can be used as data holders in a data binding framework.

- The primary purpose of ObservableField is to enable two-way data binding between the user interface (UI) and the underlying data model. It allows automatic updating of UI elements whenever the data in the ObservableField changes and vice versa. This simplifies the process of keeping the UI in sync with the data, as changes to the data are automatically propagated to the UI.

## To achieve *ObservableFields* follow the below steps
- We have made very basic example to let you understand how ObservableField works. You can use it for more vast projects and simplify your code well.
 
## Step : 1 - 
* Create viewModel and declare & initialize observable variable i,e - **'liveText'** like below.
* Also extend viewModle class with **'DefaultLifecycleObserver'**, This will handle lifecycle of **'ObservableField'** class and notify about data changes to observable variable.
* For simplicity, We have taken **"Dummy Live Text"** as default data, But you can provide your own data to this variable using **Set** method.

      class MainViewModel: ViewModel(), DefaultLifecycleObserver {
      
          val liveText = ObservableField("Dummy Live Text")
      }

## Step : 2 - 
* First we need to **convert** our xml layout in to **data binding** by right click on writing field and choose convert to data binding.
* Your Default parent layout will changed to <layout...> </layout> this structure.

      <layout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:app="http://schemas.android.com/apk/res-auto"
          xmlns:tools="http://schemas.android.com/tools">
      
          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              tools:context=".MainActivity">
              
          </androidx.constraintlayout.widget.ConstraintLayout>
      </layout>

* Now declare data variable like below for getting reference of our **liveText** varibel from viewModel class.

       <data>
            <variable
                name="viewModel"
                type="com.flipbay.observablefields.MainViewModel" />
       </data>
      
* We would need EditText for changing data in our live data variable **'LiveText'**, By Using two way binding which is done like **@={observable_variable}** this typing text will update **'liveText'** and when data changes in EditText view then by using one way binding we will update the TextView.
* Now, declare TextView and EditText for implementation of our example of ObservableFields.
* Use one way binding as **@{observable_variable}** to get updates of observable varibale and use two way binding as **@={observable_variable}** to send/get updates from observable varible which is **'liveText'**.
* Our whole xml file would look like this.
      
      <layout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:app="http://schemas.android.com/apk/res-auto"
          xmlns:tools="http://schemas.android.com/tools">
      
          <data>
              <variable
                  name="viewModel"
                  type="com.flipbay.observablefields.MainViewModel" />
          </data>
      
          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              tools:context=".MainActivity">
      
              <TextView
                  android:id="@+id/text_live"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text="@{viewModel.liveText}"
                  tools:text="Live Text View"
                  app:layout_constraintBottom_toTopOf="@id/editText_live"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toTopOf="parent"/>
      
              <EditText
                  android:id="@+id/editText_live"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_marginHorizontal="20dp"
                  android:text="@={viewModel.liveText}"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/text_live"
                  app:layout_constraintBottom_toBottomOf="parent" />
      
          </androidx.constraintlayout.widget.ConstraintLayout>
      </layout>

  ## Step : 3 -
  - For executing all process of observer we need lifecycle aware owner, Life cycle aware owner can be fragment/activity or any customView.
  - Declare and initialize binding and viewModel in activity file,
  - Then, provide connection between viewmodel and  binding's data varibale **viewModel** in xml file like below.
 
        class MainActivity : AppCompatActivity() {
    
        private var _binding: ActivityMainBinding? = null
        private val binding get() = _binding
        private val viewModel by viewModels<MainViewModel>()
    
          override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
              _binding = ActivityMainBinding.inflate(layoutInflater)
              setContentView(binding?.root)
              binding?.viewModel = viewModel
          }
    
           override fun onDestroy() {
              super.onDestroy()
              _binding = null
          }
          
        }
 

  ## Final OutPut
  <img src="https://github.com/AndroidTechTricks/ObservableFields/assets/138967229/be349bea-24c4-4df9-b5f4-e14fbd0158eb" alt="ObservableField" width="300">[ObservableField.webm](https://github.com/AndroidTechTricks/ObservableFields/assets/138967229/be349bea-24c4-4df9-b5f4-e14fbd0158eb)


    ## You have successfully learnt the basic of **ObservableField**, Now apply this to your own projects
