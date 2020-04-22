public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int sizeOfList;
    @Override

    // Inserting elements
    public void insert(T data) {

        ++this.sizeOfList;

        if( root == null) {
            this.root = new Node<>(data); // By setting the root if the list is empty
        } else {
            insertDataAtBeginning(data); // Inserting at the beginning otherwise
        }

    }

    // Inserting at the beginning
    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root); // Set the next node to be root
        this.root = newNode; // Set root as the new node
    }

    // Inserting at the beginning
    private void insertDataAtEnd(T data, Node<T> node) {
        if(node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode()); // Recursively get to the end
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode); // Add data
        }
    }

    @Override
    public void remove(T data) {
        if(this.root == null) return;

        --this.sizeOfList;

        if(this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode(); // If the data is matched, delete
        } else {
            remove(data, root, root.getNextNode()); // Move recursively until the next node is found
        }
    }

    // Helper method to move recurisively
    public void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
        while(actualNode != null) {
            if(actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }

    }

    // Print itemss
    @Override
    public void traverseList() {
        if (this.root == null) return;

        Node<T> actualNode = this.root;

        while(actualNode != null) {
            System.out.print(actualNode+" -> ");
            actualNode = actualNode.getNextNode();
        }

    }

    // Return the size of the list
    @Override
    public int size() {
        return this.sizeOfList;
    }
}
