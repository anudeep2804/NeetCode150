package Trees;

/*

value '-1' in input array represents null node
if the input provided cannot actually form a BT , you might see ArrayIndexOutofBoundsException.
 */

import java.sql.SQLOutput;

public class Build_BTree_From_Array {

    static class Node {
        int data;
        Node left;
        Node right;


        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        /*
        PreOrder - Root , Left , Right
        Time Complexity - O(n)
         */
        public static void  preorder(Node root){

            System.out.print(root.data +" ");
            if(root.left!=null){
                preorder(root.left);
            }
            if(root.right!=null){
                preorder(root.right);
            }

            if(root.left==null && root.right==null){
                return;
            }
        }
        /*
       InOrder - Left , Root , Right.
       Time Complexity - O(n)
        */
        public static void inorder(Node root){

            if(root==null){
                return;
            }

           inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }

        public static void postorder (Node root){
            if(root==null){
                return;}
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");


        }
    }


    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        System.out.println("*****  PreOderver Traversal ***** ");
        tree.preorder(root);
        System.out.println();
        System.out.println("***** InOrder Traversal********** ");
        tree.inorder(root);
        System.out.println();
        System.out.println("***** PostOrder Traversal********** ");
        tree.postorder(root);
        System.out.println();
        System.out.println("************************************");
    }

}
