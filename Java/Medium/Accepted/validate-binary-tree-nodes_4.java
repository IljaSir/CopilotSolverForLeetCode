class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            } else if (in[i] > 1) {
                return false;
            }
        }
        if (root == -1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        dfs(leftChild, rightChild, root, visited);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    private void dfs(int[] leftChild, int[] rightChild, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        if (leftChild[node] != -1) {
            dfs(leftChild, rightChild, leftChild[node], visited);
        }
        if (rightChild[node] != -1) {
            dfs(leftChild, rightChild, rightChild[node], visited);
        }
    }
}