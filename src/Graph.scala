package graph.immutable

class Graph (private val nodes:Set[Any], private val links:Map[Any, Any]){
  if (!links.keys.forall(key => nodes.contains(key))) {
    throw new IllegalArgumentException
  }
  if (!links.values.forall(value => nodes.contains(value))) {
    throw new IllegalArgumentException
  }
  def this(){
    this(Set[Any](), Map[Any, Any]())
  }

  def isEmpty ():Boolean =  {
    nodes.isEmpty
  }

  def size ():Int = {
    nodes.size
  }
}












