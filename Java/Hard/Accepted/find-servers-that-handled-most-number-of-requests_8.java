class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        int[] count = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                int[] a = pq.poll();
                set.add(a[1]);
            }
            Integer next = set.ceiling(i % k);
            if (next == null) {
                next = set.ceiling(0);
            }
            if (next != null && next < k) {
                count[next]++;
                pq.add(new int[]{arrival[i] + load[i], next});
                set.remove(next);
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
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