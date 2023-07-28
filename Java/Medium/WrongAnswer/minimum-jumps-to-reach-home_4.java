class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<Integer> forb = new HashSet<>();
        for (int i : forbidden) forb.add(i);
        if (forb.contains(0)) return -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == x) return ans;
                int next1 = cur + a;
                int next2 = cur - b;
                if (next1 == x || next2 == x) return ans + 1;
                if (next1 < 6000 && !forb.contains(next1) && !seen.contains(next1)) {
                    q.add(next1);
                    seen.add(next1);
                }
                if (next2 > 0 && !forb.contains(next2) && !seen.contains(next2)) {
                    q.add(next2);
                    seen.add(next2);
                }
            }
            ans++;
        }
        return -1;
    }
}