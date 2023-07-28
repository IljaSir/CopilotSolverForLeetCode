class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) {
                res[0] = i;
            }
            if (arr[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}