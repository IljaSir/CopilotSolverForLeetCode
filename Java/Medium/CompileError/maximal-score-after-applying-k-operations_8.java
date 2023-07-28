class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        while (k > 0) {
            int curr = minHeap.poll();
            minHeap.add(curr / 3);
            k--;
        }
        long result = 0;
        for (int num : minHeap) {
            result += num;
        }
        return result;
    }

    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] leftSum = new int[k + 1];
        int[] rightSum = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= k; i++) {
            rightSum[i] = rightSum[i - 1] + nums[n - i];
        }
        int result = 0;
        for (int i = 0; i <= k; i++) {
            result = Math.max(result, leftSum[i] + rightSum[k - i] + maxKelements(nums, k - i));
        }
        return result;
    }
}