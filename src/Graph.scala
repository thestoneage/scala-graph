package graph.immutable

import collection.immutable.HashMap

class Graph[T] (val nodes:List[T], edgeList:List[(T, T)]){
  if (!edgeList.forall{ case (source, target) => nodes.contains(source) && nodes.contains(target)}) {
    throw new IllegalArgumentException("The Source/Target Nodes of an edge have to be graph members.")
  }
  val edges = generateEdgeMap(nodes, edgeList)

  private def generateEdgeMap(ns:List[T], es:List[(T,T)]):Map[T, List[T]] = {
    val pairs = ns.map{ node => (node,  es.filter{ case (source, target) => source == node }.map{ case (src, tgt) => tgt} ) }
    val edges = Map[T, List[T]]() ++ pairs
    return edges
  }

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
    val (source, target) = edge
    edges(source).contains(target)
  }

  def adjacent(node:T):List[T] = {
    edges(node)
  }
}












