class Solution {
    public int[] leftRigthDifference(int[] nums) {
        
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] answer = new int[nums.length];
        leftSum[0] = 0;
        rightSum[nums.length-1] = 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10,4,8,3};
        int[] answer = s.leftRigthDifference(nums);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}