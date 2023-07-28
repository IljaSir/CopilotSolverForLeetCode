class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];
        int e = 0;
        int o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[e++] = nums[i];
            } else {
                odd[o++] = nums[i];
            }
        }
        Arrays.sort(even, 0, e);
        Arrays.sort(odd, 0, o);
        int k = 0;
        for (int i = 0; i < e; i++) {
            nums[k++] = even[i];
        }
        for (int i = o - 1; i >= 0; i--) {
            nums[k++] = odd[i];
        }
        return nums;
    }
}