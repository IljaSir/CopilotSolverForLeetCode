class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            } else if (inDegree[i] > 1) {
                return false;
            }
        }
        if (root == -1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        dfs(root, leftChild, rightChild, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    private void dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (root == -1) {
            return;
        }
        visited[root] = true;
        dfs(leftChild[root], leftChild, rightChild, visited);
        dfs(rightChild[root], leftChild, rightChild, visited);
    }
}