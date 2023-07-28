class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<Integer> forb = new HashSet<>();
        for (int f : forbidden) forb.add(f);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0], step = cur[1];
            if (pos == x) return step;
            if (pos + a <= 6000 && !forb.contains(pos + a) && !seen.contains(pos + a)) {
                q.offer(new int[]{pos + a, step + 1});
                seen.add(pos + a);
            }
            if (pos - b >= 0 && !forb.contains(pos - b) && !seen.contains(pos - b) && pos - b != pos + a) {
                q.offer(new int[]{pos - b, step + 1});
                seen.add(pos - b);
            }
        }
        return -1;
    }
}