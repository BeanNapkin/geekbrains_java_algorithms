public class Tree {

    public Node root;
    public Person person;

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (node.person.id > current.person.id) {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                } else {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int id) {

        Node current = root;

        while (current != null && current.person.id != id) {
            if (current.person.id > id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return current;
    }

    public Node findParent(int id) {

        Node current = root;
        Node parent = root;

        while (current != null && current.person.id != id) {
            if (current.person.id > id) {
                parent = current;
                current = current.leftChild;
            } else {
                parent = current;
                current = current.rightChild;
            }
        }

        return parent;
    }

    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
        }
    }

    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    public Node max() {
        Node current = root;

        while (current.rightChild != null) {
            current = current.rightChild;
        }

        return current;
    }

    public Node min() {
        Node current = root;

        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current;
    }

    public boolean delete(int id) {
        Node parentNodeToDelete = findParent(id);

        Boolean isNodeToDeleteLeftChild = true;
        Node nodeToDelete = parentNodeToDelete.leftChild;

        if (id > parentNodeToDelete.person.id) {
            isNodeToDeleteLeftChild = false;
            nodeToDelete = parentNodeToDelete.rightChild;
        }

        if (nodeToDelete == null) {
            return false;
        }

        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (isNodeToDeleteLeftChild) {
                parentNodeToDelete.leftChild = null;
            } else {
                parentNodeToDelete.rightChild = null;
            }
        } else if (nodeToDelete.rightChild == null && nodeToDelete.leftChild != null) {
            if (isNodeToDeleteLeftChild) {
                parentNodeToDelete.leftChild = nodeToDelete.leftChild;
            } else {
                parentNodeToDelete.rightChild = nodeToDelete.leftChild;
            }
        } else if (nodeToDelete.rightChild != null && nodeToDelete.leftChild == null) {
            if (isNodeToDeleteLeftChild) {
                parentNodeToDelete.leftChild = nodeToDelete.rightChild;
            } else {
                parentNodeToDelete.rightChild = nodeToDelete.rightChild;
            }
        } else {

            Node successor = nodeToDelete.rightChild;

            while (successor.leftChild != null) {
                successor = successor.leftChild;
            }

            if (isNodeToDeleteLeftChild) {
                parentNodeToDelete.leftChild = successor;
            } else {
                parentNodeToDelete.rightChild = successor;
            }

            successor.leftChild = nodeToDelete.leftChild;

            if (successor != nodeToDelete.rightChild) {
                successor.rightChild = nodeToDelete.rightChild;
            }
        }

        return true;
    }


    private class Node {
        Person person;
        private Node leftChild;
        private Node rightChild;

        public void display() {
            System.out.println(person.name);
        }
    }
}
