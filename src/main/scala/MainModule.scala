import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

/**
  * Created by ASrivastava on 4/29/17.
  */
class MainModule extends ScalaModule {
   override def configure() = {
      bind[Test1]
      bind[Test2]
      bind[TestPartialMock]
   }
}
