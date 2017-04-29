/**
  * Created by ASrivastava on 4/29/17.
  */


import com.google.inject.Inject
class TestPartialMock @Inject()(t1: Test1, t2: Test2) {
   def test3() = "I do test3"
   def workHorse() : List[String] = {
      if (t1 == null) println("t1 is null")
      if (t2 == null) println("t2 is null")
      List(t1.test1(), t2.test2(), test3())
   }
}
