class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        for(int i = 0; i < count.length; i++){
            pairs += count[i] / 2;
            count[i] = count[i] % 2;
        }
        int[] res = {pairs, 0};
        for(int i = 0; i < count.length; i++){
            res[1] += count[i];
        }
        return res;
    }
}