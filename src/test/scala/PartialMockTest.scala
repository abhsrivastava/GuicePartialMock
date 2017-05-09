import com.google.inject._
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
      bind(classOf[TestPartialMock]).toInstance(x)
   }
}

//class TestModule extends AbstractModule with ScalaModule with MockitoSugar {
//   override def configure() = {
//      bind[TestPartialMock].toProvider(new TestPartialMockProvider({ x =>
//         when(x.test3()).thenReturn("I am mocked")
//      }))
//   }
//}
//
//class TestPartialMockProvider(f: TestPartialMock => Unit) extends Provider[TestPartialMock] {
//   @Inject var injector : Injector = _
//   override def get() : TestPartialMock = {
//      import net.codingwell.scalaguice.InjectorExtensions._
//      val instance = new TestPartialMock(injector.instance[Test1], injector.instance[Test2])
//      val x = spy(instance)
//      f(x)
//      x
//   }
//}