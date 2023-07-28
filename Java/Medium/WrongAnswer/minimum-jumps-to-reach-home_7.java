class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int max = 6000;
        boolean[] forb = new boolean[max];
        for (int f : forbidden) forb[f] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[] seen = new boolean[max];
        seen[0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0], step = cur[1];
            if (pos == x) return step;
            int[] next = new int[]{pos + a, pos - b};
            for (int i = 0; i < 2; i++) {
                if (next[i] >= 0 && next[i] < max && !forb[next[i]] && !seen[next[i]]) {
                    q.offer(new int[]{next[i], step + 1});
                    seen[next[i]] = true;
                    if (i == 1) forb[next[i]] = true;
                }
            }
        }
        return -1;
    }
}