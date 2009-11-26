import graph.immutable.Graph
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class GraphSpec extends Spec with ShouldMatchers{
        describe("A Graph") {
          describe("when empty") {
            val graph = (new Graph)
            it("should be empty") {
              graph should be ('empty)
            }
            it("should have a size of 0"){
              graph should have size (0)
            }
          }
          describe("when non-empty"){
            val graph = (new Graph( Set[Any](1,2,3), Map[Any, Any]() ))
            it("should not be empty"){
              graph should not be ('empty)
            }
          }
          describe("when initialized"){
            it("should raise an exception if the source or target of the links are not members of the graph"){
              evaluating (new Graph(Set(1),Map(1 -> 2))) should produce [IllegalArgumentException]
              evaluating (new Graph(Set(1),Map(2 -> 1))) should produce [IllegalArgumentException]
            }
          }
        }
}