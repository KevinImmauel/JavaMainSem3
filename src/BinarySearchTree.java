class Node {
    int data;
    Node left;
    Node right;
    Node(int d){
        data = d;
    }
}
public class BinarySearchTree {
    Node root;

    void insert(int data){
        Node nn = new Node(data);
        if (root == null){
            root = nn;
        }else{
            Node t1 = root;
            Node t2 = null;
            while(t1 != null){
                t2 = t1;
                if (t1.data < data){
                    t1 = t1.right;
                }else{
                    t1 = t1.left;
                }
            }
            if (data > t2.data){
                t2.right = nn;
            }else{
                t2.left = nn;
            }
        }
    }
    void preorder(Node root){
        if (root!=null){
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void inorder(Node root){
        if (root!=null){
            postorder(root.left);
            System.out.println(root.data + " ");
            postorder(root.right);
        }
    }
    void postorder(Node root){
        if (root!=null){
            postorder(root.right);
            postorder(root.left);
            System.out.println(root.data + " ");
        }
    }
    int max(Node root){
        Node t = root;
        while(t.right!=null){
            t = t.right;
        }
        return t.data;
    }
    int min(Node root){
        Node t = root;
        while(t.left!=null){
            t = t.left;
        }
        return t.data;
    }
    int height(Node root){
        if(root==null){
            return -1;
        }else{
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh>rh){
                return lh+1;
            }else{
                return rh+1;
            }
        }
    }
    static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    Node delNode(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.data > x) {
            root.left = delNode(root.left, x);
        } else if (root.data < x) {
            root.right = delNode(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delNode(root.right, succ.data);
        }
        return root;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(16);
        bst.insert(5);
        bst.insert(19);
        bst.insert(14);
        bst.insert(8);
        bst.insert(1);
        bst.inorder(bst.root);
        int x = 10;
        bst.root = bst.delNode(bst.root, x);
        System.out.println("After deletion");
        bst.preorder(bst.root);
    }
}