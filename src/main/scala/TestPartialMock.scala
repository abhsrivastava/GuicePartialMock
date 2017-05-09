/**
  * Created by ASrivastava on 4/29/17.
  */


import javax.inject.Singleton

import com.google.inject.Inject
@Singleton
class TestPartialMock @Inject()(t1: Test1, t2: Test2) {
   def test3() = "I do test3"
   def workHorse() : List[String] = {
      println("+++++ came inside ++++++++")
      List(t1.test1(), t2.test2(), test3())
   }
}
