class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            answer[0] += count[i] / 2;
            answer[1] += count[i] % 2;
        }
        return answer;
    }
}