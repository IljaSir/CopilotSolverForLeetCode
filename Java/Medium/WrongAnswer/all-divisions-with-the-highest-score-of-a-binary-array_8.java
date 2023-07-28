class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        int[] count = new int[2];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int maxScore = count[0];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]--;
            if(count[0] + count[1] > maxScore) {
                maxScore = count[0] + count[1];
                result.clear();
                result.add(i+1);
            } else if(count[0] + count[1] == maxScore) {
                result.add(i+1);
            }
            count[nums[i]]++;
        }
        return result;
    }
}