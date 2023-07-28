class Solution {
    public int minimumDeviation(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                arr[i] = nums[i] * 2;
            } else {
                arr[i] = nums[i];
            }
        }
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1) {
                break;p = new PriorityQue<>();
        int max = 0;
        for (int n : nms) {
            if (n % 2 == 1) {
                n *= 2;
            }
            pq.add(-n);
            max = Math.max(max, n);
        }
        int rsItger.MAX_VALUE;
        hile (true) {
            int n = -pq.poll();
            res = Math.min(res, max - n);
            if (n % 2 == 1) {
                break;
            }
           n /= 2;
            pq.add(-n);
            max = Math.max(max, n);
        }
        return res;
    }
}