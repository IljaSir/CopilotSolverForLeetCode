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
            }
        }
        if (root == -1) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        seen.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (leftChild[cur] != -1) {
                if (seen.contains(leftChild[cur])) {
                    return false;
                }
                q.offer(leftChild[cur]);
                seen.add(leftChild[cur]);
            }
            if (rightChild[cur] != -1) {
                if (seen.contains(rightChild[cur])) {
                    return false;
                }
                q.offer(rightChild[cur]);
                seen.add(rightChild[cur]);
            }
        }
        return seen.size() == n;
    }
}