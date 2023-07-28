class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (arr[a[0]] * arr[b[1]]) - (arr[a[1]] * arr[b[0]]));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[] {i, n - 1});
        }
        int[] ans = new int[2];
        while (k-- > 0) {
            int[] p = pq.poll();
            ans[0] = arr[p[0]];
            ans[1] = arr[p[1]];
            if (p[1] - 1 > p[0]) {
                pq.add(new int[] {p[0], p[1] - 1});
            }
        }
        return ans;
    }
}