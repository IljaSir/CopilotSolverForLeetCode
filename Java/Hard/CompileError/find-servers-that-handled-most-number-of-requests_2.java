class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                available.add(pq.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            int idx = arrival[i] % k;
            Integer next = available.ceiling(idx);
            if (next == null) {
                next = available.ceiling(0);
            }
            available.remove(next);
            pq.offer(new int[] {arrival[i] + load[i], next});
            count[next]++;
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }
====   

        PriorityQueue<int[]> pq   new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> available   new TreeSet<>();
        for (int i   0; i < k; i++) {
            available.add(i);
        }
        int[] count   new int[k]; return ans;
        int max = 0;
       =for=(int=i===0;=i=<arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                available.add(pq.poll()[1]);
            }
            Integer server = available.ceiling(i % k);
            if (server == null) {
                server = available.ceiling(0);
            }
            if (server != null) {
                pq.add(new int[]{arrival[i] + load[i], server});
                available.remove(server);
                count[server]++;
                max = Math.max(max, count[server]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}