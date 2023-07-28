class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            pq.add(-nums[i]);
        }
        for(int i = 0; i < k; i++) {
            int n = pq.poll();
            pq.add((int)Math.ceil(n/3.0));
        }
        long res = 0;
        while(!pq.isEmpty()) {
            res += -pq.poll();
        }
        return res;
    }
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] + nums[i];
        }
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + nums[i];
        }
        int max = 0;
        for(int i = 0; i <= k; i++) {
            int l = i == 0 ? 0 : left[i-1];
            int r = k-i == 0 ? 0 : right[n-k+i];
            max = Math.max(max, l + r);
        }
        return max;
    }
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] + nums[i];
        }
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + nums[i];
        }
        int max = 0;
        for(int i = 0; i <= k; i++) {
            int l = i == 0 ? 0 : left[i-1];
            int r = k-i == 0 ? 0 : right[n-k+i];
            max = Math.max(max, l + r);
        }
        return max;
    }
}