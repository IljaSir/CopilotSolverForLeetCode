class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        
        int[] target = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(j > index[i]){
                target[j] = target[j - 1];
                j--;
            }
            target[index[i]] = nums[i];
        }
        return target;
    }
}