package btree;

/**
 *
 * @author kamaj  / jessevaa
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    }
    
    public void insert(String aData){
        if (root == null) {
            root = new Node(aData, new BinaryTree(), new BinaryTree());
        } else if (aData.compareTo(root.getData()) < 0) {
            if (root.left() != null) {
                root.left().insert(aData);
            } else {
                this.setLeft(new BinaryTree(aData));
            }
        } else {
            if (root.right() != null) {
                root.right().insert(aData);
            } else {
                this.setRight(new BinaryTree(aData));
            }
        }
    }
    
    public BinaryTree find(String aData){
        if (root.getData().contentEquals(aData)) return this;
        if (aData.compareTo(root.getData()) < 0) {
            return root.left().root == null ? null : root.left().find(aData);
        } else {
            return root.right().root == null ? null : root.right().find(aData);
        }
    }
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }
    }
  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
