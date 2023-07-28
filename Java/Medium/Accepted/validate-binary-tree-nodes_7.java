class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            int l = leftChild[i];
            int r = rightChild[i];
            if (l != -1) {
                in[l]++;
            }
            if (r != -1) {
                in[r]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        if (root == -1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            int l = leftChild[node];
            int r = rightChild[node];
            if (l != -1) {
                q.offer(l);
            }
            if (r != -1) {
                q.offer(r);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}