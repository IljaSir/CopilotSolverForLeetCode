class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != 0) {
                    return false;
                }
                parent[leftChild[i]] = i + 1;
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != 0) {
                    return false;
                }
                parent[rightChild[i]] = i + 1;
            }
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == 0) {
                root++;
            }
        }
        if (root != 1) {
            return false;
        }
        return true;
    }
}