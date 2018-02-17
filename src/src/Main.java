import java.util.ArrayList;
import java.util.List;

/*
Object Node which contains the data, and both children.
 */
class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node (int data) {
        this.data = data;
        leftChild = rightChild = null;
    }

    public void pushNode(Node node){
        if (node.data <= this.data){
              if (this.leftChild == null){
                  this.leftChild = node;
              } else {
                  this.leftChild.pushNode(node);
              }
        } else {
            if (this.rightChild == null){
                this.rightChild = node;
            } else {
                this.rightChild.pushNode(node);
            }
        }
    }
}

class BinaryTree {
    Node root;
}

public class Main {
    public static void main (String [] args){
        int [] data = {3,7,1,8,4,9,2,4,6,1};

        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < data.length; i++){
            Node node = new Node(data[i]);

            if (binaryTree.root == null){
                binaryTree.root = node;
                continue;
            }

            binaryTree.root.pushNode(node);
        }
    }

}
