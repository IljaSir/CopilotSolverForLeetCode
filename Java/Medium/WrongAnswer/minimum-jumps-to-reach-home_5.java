class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == x) {
                    return step;
                }
                int next = cur + a;
                if (next == x || (next < x && !forbiddenSet.contains(next) && !visited.contains(next))) {
                    return step + 1;
                }
                if (next < x && !forbiddenSet.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
                next = cur - b;
                if (next >= 0 && !forbiddenSet.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}