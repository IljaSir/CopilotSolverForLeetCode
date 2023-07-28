class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        List<Boolean> answer = new ArrayList<Boolean>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = ((num << 1) + nums[i]) % 5;
            answer.add(num == 0);
        }
        return answer;
    }
}