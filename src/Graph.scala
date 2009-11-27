package graph.immutable

import collection.immutable.HashMap

class Graph[T] (val nodes:List[T], edgeList:List[(T, T)]){
  if (!edgeList.forall{ case (source, target) => nodes.contains(source) && nodes.contains(target)}) {
    throw new IllegalArgumentException
  }
  val edges = HashMap[T, List[T]]() ++ ( nodes.map({node => ( node, (List[T]() ++ edgeList.filter{ case (source, target) => source == node} ))}) )
  

  def this(){
    this(List[T](), List[(T, T)]())
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

  def contains (edge:(T, T)):Boolean = {
    edge match {
      case (source, target) => edges.get(source).get.contains(edge)
    }
  }

  
}












