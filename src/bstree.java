public class bstree {
    Node root = null;

    public static int heightoftree(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(heightoftree(root.left), heightoftree(root.right));
        }
    }

    public static void main(String[] args) {
        bstree obj = new bstree();
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);
        obj.insert(60);

        System.out.println("Binary search tree after insetion");
        obj.inorder(obj.root);
        System.out.println("Binary serach tree after postorder");
        obj.postorder(obj.root);
        System.out.println("binary serach tree after preorder");
        obj.preorder(obj.root);

        Node deleteNode = null;
        deleteNode = obj.deleteNode(obj.root, 10);
        System.out.println("Binary serach tree after deleting node 10");
        obj.inorder(obj.root);
        System.out.println("height of tree" + " " + obj.heightoftree(obj.root));
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node temp = root;
            Node parent = null;
            while (temp != null) {
                parent = temp;
                if (data <= temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (data <= parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    public Node minnode(Node root) {
        if (root.left != null)
            return minnode(root.left);
        else
            return root;
    }

    public Node deleteNode(Node node, int x) {
        if (node == null) {
            return null;
        } else {
            if (x < node.data)
                node.left = deleteNode(node.left, x);

            else if (x > node.data)
                node.right = deleteNode(node.right, x);

            else {
                if (node.left == null && node.right == null)
                    node = null;

                else if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {
                    Node temp = minnode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        } else {
            if (node.left != null)
                postorder(node.left);
            if (node.right != null)
                postorder(node.right);
            System.out.println(node.data + " ");
        }
    }

    public void preorder(Node node) {
        if (root == null) {
            return;
        } else {
            System.out.println(node.data + " ");
            if (node.left != null)
                preorder(node.left);
            if (node.right != null)
                preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (root == null) {
            return;
        } else {
            if (node.left != null)
                inorder(node.left);
            System.out.println(node.data + " ");
            if (node.right != null)
                inorder(node.right);
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}