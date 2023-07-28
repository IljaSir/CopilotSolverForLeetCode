class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == index[i]) {
                target[i] = nums[i];
            } else {
                int temp = target[index[i]];
                target[index[i]] = nums[i];
                for (int j = index[i] + 1; j <= i; j++) {
                    int temp2 = target[j];
                    target[j] = temp;
                    temp = temp2;
                }
            }
        }
        return target;
    }
}