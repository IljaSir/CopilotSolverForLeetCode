class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target[index[i]] == -1) {
                target[index[i]] = nums[i];
            } else {
                int j = nums.length - 1;
                while (j > index[i]) {
                    target[j] = target[j - 1];
                    j--;
                }
                target[index[i]] = nums[i];
            }
        }
        return target;
    }
}