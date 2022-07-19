package com.example.dealer

import kotlin.math.pow
import kotlin.math.sqrt

class Node(var x: Int, var y: Int) {

    var path: Double? = null
    var next: Node? = null

    fun appendToEnd(x: Int, y: Int) {
        val begin = this
        val newNode = Node(x, y)
        var tempNode: Node? = this

        newNode.path = calculateEuclideanDistance(begin, newNode)

        while (tempNode!!.next != null) {
            tempNode = tempNode.next
        }
        tempNode.next = newNode
    }

    private fun calculateEuclideanDistance(Point1: Node, Point2: Node): Double {

        val distX = (Point1.x - Point2.x).toDouble().pow(2)
        val distY = (Point1.y - Point2.y).toDouble().pow(2)

        return sqrt((distX + distY))
    }

    fun sumOfNodes(): Double {
        var sumOfNodes = 0.0
        val head = this
        var tempNode: Node? = head

        while (tempNode != null) {
            sumOfNodes += tempNode.path!!
            tempNode = tempNode.next
        }
        return sumOfNodes
    }
}