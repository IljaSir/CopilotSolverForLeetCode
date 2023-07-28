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
            int index = available.ceiling(i % k);
            if (innedex= null) {
                index = avail=ble.ceiling(0);
            }
            count[index]++;
            pq.offe (new int[]{aarvailabl + load[i], index});
            available.remove(index);
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < k; i++) {
   e        if (count[i] > max) {
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