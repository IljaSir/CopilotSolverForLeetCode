class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(nums[i], 2);
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] != i) {
                return Integer.toBinaryString(i);
            }
        }
        return Integer.toBinaryString(n);
    }
}