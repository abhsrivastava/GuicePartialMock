import com.google.inject.Guice

/**
  * Created by ASrivastava on 4/29/17.
  */
object Runner extends App {
   val mainModule = new MainModule()
   val injector = Guice.createInjector(mainModule)
   val tpm = injector.getInstance(classOf[TestPartialMock])
   tpm.workHorse().foreach(println)
}
