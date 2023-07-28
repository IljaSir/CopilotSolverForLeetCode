class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(i, visited, inStack, leftChild, rightChild)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int i, boolean[] visited, boolean[] inStack, int[] leftChild, int[] rightChild) {
        if (inStack[i]) {
            return false;
        }
        if (visited[i]) {
            return true;
        }
        inStack[i] = true;
        visited[i] = true;
        if (leftChild[i] != -1) {
            if (!dfs(leftChild[i], visited, inStack, leftChild, rightChild)) {
                return false;
            }
        }
        if (rightChild[i] != -1) {
            if (!dfs(rightChild[i], visited, inStack, leftChild, rightChild)) {
                return false;
            }
        }
        inStack[i] = false;
        return true;
    }
}