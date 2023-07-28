class Solution {
    public int getMinSwaps(String num, int k) {
        
        char[] c = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(c);
        }
        int ans = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != num.charAt(i)) {
                int j = i + 1;
                while (c[j] != num.charAt(i)) {
                    j++;
                }
                while (j > i) {
                    char t = c[j];
                    c[j] = c[j - 1];
                    c[j - 1] = t;
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }
    private void nextPermutation(char[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void reverse(char[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}