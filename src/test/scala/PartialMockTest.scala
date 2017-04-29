import com.google.inject.{AbstractModule, Guice}
import net.codingwell.scalaguice.ScalaModule
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

/**
  * Created by ASrivastava on 4/29/17.
  */
class PartialMockTest extends FunSpec with Matchers {
   describe("we are testing workhorse but mock test3") {
      it("should return mock for test3") {
         val module = new TestModule
         val injector = Guice.createInjector(module)
         val tpm = injector.getInstance(classOf[TestPartialMock])
         val result = tpm.workHorse()
         result should contain ("i do test2")
         result should contain ("i do test1")
         result should contain ("I am mocked")
         result should not contain ("I do test3")
      }
   }
}

class TestModule extends AbstractModule with ScalaModule with MockitoSugar {
   override def configure() = {
      val module = new MainModule()
      val injector = Guice.createInjector(module)
      val realobject = injector.getInstance(classOf[TestPartialMock])
      val x = spy(realobject)
      when(x.test3()).thenReturn("I am mocked")
      when(x.workHorse()).thenCallRealMethod()
      bind(classOf[TestPartialMock]).toInstance(x)
   }
}
