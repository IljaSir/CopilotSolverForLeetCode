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
            int idx = arrival[i] .ceiling(i % k);
            if (index == null) {
                index = available.ceiling(0);
            }
            count[index]++;
            pq.offer(new int[]{arrival[i] + load[i], index});
            available.remove(index);
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (count[i] > max) {
                res.clear();
                res.add(i);
                max = count[i];
            } else if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}