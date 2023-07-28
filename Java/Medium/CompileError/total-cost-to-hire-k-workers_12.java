class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        if (k == n) {
            long ans = 0;
            for (int cost : costs) {
                ans += cost;
            }
            return ans;
        }
        long ans = Long.MAX_VALUE;
        Arrays.sort(costs);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            pq.add(costs[i]);
            sum += costs[i];
        }
        ans = Math.min(ans, sum + (long) (k - 1) * (costs[k - 1] - costs[0]));
        for (int i = k; i < n; i++) {
            pq.add(costs[i]);
            sum += costs[i];
            sum -= pq.poll();
            ans = Math.min(ans, sum + (long) (k - 1) * (costs[i] - costs[i - k + 1]));
        }
        return ans;
    }
}
    }
}