class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> busy = new PriorityQueue<Integer>();
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            while (!busy.isEmpty() && busy.peek() <= start) {
                pq.add(busy.poll());
            }
            if (pq.isEmpty()) {
                continue;
            }
            int server = pq.poll();
            busy.add(start + load[i]);
            count[server]++;
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
        return ans;
    }
}