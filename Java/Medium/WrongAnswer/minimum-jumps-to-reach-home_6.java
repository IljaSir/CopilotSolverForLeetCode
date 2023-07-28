class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int max = 6000;
        Set<Integer> set = new HashSet<>();
        for (int f : forbidden) {
            set.add(f);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[] visited = new boolean[max];
        visited[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == x) {
                    return ans;
                }
                int next = cur[0] + a;
                if (next < max && !visited[next] && !set.contains(next)) {
                    visited[next] = true;
                    q.add(new int[]{next, 0});
                }
                if (cur[1] == 0) {
                    next = cur[0] - b;
                    if (next >= 0 && !visited[next] && !set.contains(next)) {
                        visited[next] = true;
                        q.add(new int[]{next, 1});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}