class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int[] freq = new int[nums.length];
        for (int[] request : requests) {
            freq[request[0]]++;
            if (request[1] + 1 < nums.length) {
                freq[request[1] + 1]--;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            freq[i] += freq[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(freq);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += (long) nums[i] * freq[i];
        }
        return (int) (sum % 1000000007);
    }
}