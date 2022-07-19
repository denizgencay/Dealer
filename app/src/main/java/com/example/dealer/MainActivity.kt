package com.example.dealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var beginNode: Node? = null
    private var nodeList = arrayListOf<Node>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        beginNode = Node(3, 7)
        beginNode!!.path = 0.0

        nodeList.add(Node(3, 7))
        nodeList.add(Node(8, 4))
        nodeList.add(Node(6, 5))
        nodeList.add(Node(1, 4))
        nodeList.add(Node(2, 1))

        beginNode!!.appendToEnd(1, 10)
        beginNode!!.appendToEnd(1, 4)
        beginNode!!.appendToEnd(2, 1)
        beginNode!!.appendToEnd(5, 2)
        beginNode!!.appendToEnd(6, 5)
        beginNode!!.appendToEnd(8, 4)
        beginNode!!.appendToEnd(8, 9)
        beginNode!!.appendToEnd(9, 2)

        binding.deleteAllNodesButton.setOnClickListener { deleteAllNodes() }
        binding.sumOfNodesButton.setOnClickListener { sumOfNodes() }
        setContentView(binding.root)
    }


    private fun deleteAllNodes() {
        beginNode!!.next = null
        toastMessageHelper("All nodes are deleted.")
    }


    private fun sumOfNodes() {
        val sumOfNodes = beginNode!!.sumOfNodes()
        val stringTotalDistance = String.format("%.5f", sumOfNodes.times(2))
        toastMessageHelper("Total Distance: $stringTotalDistance")
    }


    private fun toastMessageHelper(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}