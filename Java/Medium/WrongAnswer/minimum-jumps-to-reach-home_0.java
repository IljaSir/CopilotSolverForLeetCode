class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < forbidden.length; i++) {
            set.add(forbidden[i]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0], step = cur[1], dir = cur[2];
            if (pos == x) {
                return step;
            }
            if (pos < 0 || pos > 6000 || set.contains(pos)) {
                continue;
            }
            set.add(pos);
            if (dir != 1) {
                queue.offer(new int[]{pos - b, step + 1, -1});
            }
            queue.offer(new int[]{pos + a, step + 1, 1});
        }
        return -1;
    }
}