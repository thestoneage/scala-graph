package graph.immutable

class Graph[T] (val nodes:Set[T], edges:Set[(T, T)]){
  if (!edges.forall{ case (source, target) => nodes.contains(source) && nodes.contains(target)}) {
    throw new IllegalArgumentException
  }
  edges.foreach()
  

  def this(){
    this(Set[T](), Set[(T, T)]())
  }

  def isEmpty ():Boolean =  {
    nodes.isEmpty
  }

  def size ():Int = {
    nodes.size
  }

  def contains (node:T):Boolean = {
    nodes.contains(node)
  }

  def contains (node:(T,T)):Boolean = {
    false
  }

  
}












