class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]];
        });
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[]{i, n - 1});
        }
        while (k-- > 1) {
            int[] cur = pq.poll();
            if (cur[1] - 1 > cur[0]) {
                cur[1]--;
                pq.add(cur);
            }
        }
        int[] cur = pq.poll();
        return new int[]{arr[cur[0]], arr[cur[1]]};
    }
}