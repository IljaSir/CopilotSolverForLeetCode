class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int j = n - 1;
        for (int i = 1; i < n; i += 2) {
            nums[i] = tmp[j--];
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = tmp[j--];
        }
    }
}