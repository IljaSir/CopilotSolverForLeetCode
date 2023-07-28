class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        int n = tasks.length;
        int[] time = new int[n];
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] last = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = 1;
            next[i] = i + 1;
            prev[i] = i - 1;
            last[i] = -1;
            count[i] = 0;
        }
        next[n - 1] = -1;
        int head = 0;
        int tail = n - 1;
        while (!queue.isEmpty()) {
            int task = queue.poll();
            int cnt = map.get(task);
            while (cnt > 0) {
                int p = head;
                while (p != -1 && count[p] >= space) {
                    p = next[p];
                }
                if (p == -1) {
                    break;
                }
                time[p] = task;
                if (last[p] != -1) {
                    next[last[p]] = next[p];
                    prev[next[p]] = last[p];
                } else {
                    head = next[p];
                }
                count[p]++;
                if (count[p] == space) {
                    last[p] = tail;
                    next[tail] = p;
                    prev[p] = tail;
                    tail = p;
                }
                cnt--;
            }
            if (cnt > 0) {
                return -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}