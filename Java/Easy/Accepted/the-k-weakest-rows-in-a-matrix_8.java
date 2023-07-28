class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] res = new int[k];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int s = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) s++;
            }
            q.offer(new int[]{s, i});
        }
        for (int i = 0; i < k; i++) {
            res[i] = q.poll()[1];
        }
        return res;
    }
}