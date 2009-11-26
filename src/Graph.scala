package graph.immutable

class Graph[T] (private val nodes:Set[T], private val edges:Set[(T, T)]){
  if (!edges.forall{ case (source, target) => nodes.contains(source) && nodes.contains(target)}) {
    throw new IllegalArgumentException
  }
  def this(){
    this(Set[T](), Set[(T, T)]())
  }

  def isEmpty ():Boolean =  {
    nodes.isEmpty
  }

  def size ():Int = {
    nodes.size
  }

  
}












