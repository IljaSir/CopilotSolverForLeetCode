class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int[] res = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]));
        for (int i = 0; i < arr.length - 1; i++) {
            pq.offer(new int[]{i, arr.length - 1});
        }
        while (k-- > 0) {
            int[] cur = pq.poll();
            res[0] = arr[cur[0]];
            res[1] = arr[cur[1]];
            if (cur[1] - 1 > cur[0]) {
                cur[1]--;
                pq.offer(cur);
            }
        }
        return res;
    }
}