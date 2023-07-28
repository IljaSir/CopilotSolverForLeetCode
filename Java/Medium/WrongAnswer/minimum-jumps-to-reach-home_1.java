class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == x) {
                return cur[1];
            }
            if (cur[0] - b >= 0 && !set.contains(cur[0] - b)) {
                set.add(cur[0] - b);
                q.offer(new int[]{cur[0] - b, cur[1] + 1});
            }
            if (cur[0] + a <= 6000 && !set.contains(cur[0] + a)) {
                set.add(cur[0] + a);
                q.offer(new int[]{cur[0] + a, cur[1] + 1});
            }
        }
        return -1;
    }
}