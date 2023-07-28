class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                available.add(pq.poll()[1]);
            }
            Integer next = available.ceiling(i % k);
            if (next == null) {
                next = available.ceiling(0);
            }
            if (next != null) {
                count[next]++;
                available.remove(next);
                pq.offer(new int[]{arrival[i] + load[i], next});
            }
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
        return ans;t.add(i);
            }
        }
        return result;
    }
}