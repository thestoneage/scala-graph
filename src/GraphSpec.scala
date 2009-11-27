import collection.immutable.ListSet
import graph.immutable.Graph
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class GraphSpec extends Spec with ShouldMatchers{
        describe("A Graph") {
          describe("when empty") {
            val emptyGraph = (new Graph)
            it("should be empty") {
              emptyGraph should be ('empty)
            }
            it("should have a size of 0"){
              emptyGraph should have size (0)
            }
            it("should have an empty set of nodes"){
              emptyGraph should have ('nodes (List()))
            }
          }
          describe("when non-empty"){
            val nonEmptyGraph = (new Graph( List(1,2,3), List[(Int,Int)]() ))
            it("should not be empty"){
              nonEmptyGraph should not be ('empty)
            }
            it("should have a size which is the number of contained nodes"){
              nonEmptyGraph should have size (3)
            }
            it("should have a field representing the nodes"){
              nonEmptyGraph should have ('nodes (List(1,2,3)))
            }
            it("should contain the nodes with which it was constructed"){
              nonEmptyGraph.contains(1) should be (true)
              nonEmptyGraph.contains(2) should be (true)
              nonEmptyGraph.contains(3) should be (true)
            }
            it("should only contain the nodes with which it was constructed"){
              nonEmptyGraph.contains(4) should be (false)
            }
            it("should have a field representing edges"){
              nonEmptyGraph should have ('edges (Map(1 -> List[(Int,Int)](), 2 -> List[(Int,Int)](), 3 -> List[(Int,Int)]() )))
            }
          }
          describe("when constructed with edges"){
            val graphWithEdges = new Graph(List(1,2,3), List((1,2),(2,3)))
            it("should have a field representing edges"){
              graphWithEdges should have ('edges (Map(1 -> List((1,2)), 2 -> List((2,3)), 3 -> List[(Int, Int)]())))
            }
            it("should contain the edges with which it was constructed"){
              graphWithEdges.contains((1,2)) should be (true)
              graphWithEdges.contains((2,3)) should be (true)
            }
            it("should contain only the edges with which it was constructed") {
              graphWithEdges.contains((1,3)) should be (false)
            }
          }
          describe("when initialized"){
            it("should raise an exception if the source or target of the links are not members of the graph"){
              evaluating (new Graph(List(1),List((1, 2)))) should produce [IllegalArgumentException]
              evaluating (new Graph(List(1),List((2, 1)))) should produce [IllegalArgumentException]
            }
          }
        }
}