class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        // min heap
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]];
        });
        for (int i = 0; i < n - 1; i++) {
            q.offer(new int[]{i, n - 1});
        }
        while (k > 1) {
            int[] cur = q.poll();
            if (cur[1] - 1 > cur[0]) {
                cur[1]--;
                q.offer(cur);
            }
            k--;
        }
        int[] res = q.poll();
        return new int[]{arr[res[0]], arr[res[1]]};
    }
}