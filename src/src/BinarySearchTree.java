public class BinarySearchTree {

    /*
    Class Node with the data and the child nodes
     */
    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node (int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    //root node for the binary tree
    Node root;

    //Constructor method
    public BinarySearchTree(){
        root = null;
    }

    //Insert method for new values in the tree
    public void insert (int key){
        root = insertNode(root, key);
    }

    //Insert recursive call for inserting from the root, in the right place
    public Node insertNode (Node node, int key){
        if (node == null){
            node = new Node(key);
            return node;
        }

        if (key <= node.data){
            node.leftChild = insertNode(node.leftChild, key);
        } else if (key > root.data){
            node.rightChild = insertNode(node.rightChild, key);
        }

        return node;
    }

    //Find method asking for the node to find
    public Node find(int key){
        Node node = findNode(root, key);
        return node;
    }

    //Find recursive method using the root node.
    public Node findNode (Node node, int key){
        if (key == node.data){
            return node;
        }

        if (key <= node.data){
            if (node.leftChild == null){
                return null;
            } else {
                return findNode(node.leftChild, key);
            }
        } else if (key > node.data){
            if (node.rightChild == null) {
                return null;
            } else {
                return findNode(node.rightChild, key);
            }
        }

        return null;
    }


    public static void main (String [] args){
        int [] data = {3,7,1,8,4,9,2,4,6,1};

        BinarySearchTree binaryTree = new BinarySearchTree();

        for (int i = 0; i < data.length; i++){
            binaryTree.insert(data[i]);
        }

        Node node = binaryTree.find(10);

        if (node == null){
            System.out.println("The number does not exist");
        } else {
            System.out.println("Node " + node.data + " was found");
        }
    }

}
