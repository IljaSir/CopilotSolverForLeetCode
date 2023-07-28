class Solution {
    public String getPermutation(int n, int k) {
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n; i > 0; i--) {
            int index = k / factorials[i - 1];
            k -= index * factorials[i - 1];
            sb.append(nums[index]);
            for (int j = index; j < n - 1; j++) {
                nums[j] = nums[j + 1];
            }
        }
        return sb.toString();
    }
}