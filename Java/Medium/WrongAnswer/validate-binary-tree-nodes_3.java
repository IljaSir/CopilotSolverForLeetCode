class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1) {
                    return false;
                }
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        return root != -1;
    }
}