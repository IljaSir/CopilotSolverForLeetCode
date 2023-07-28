class Solution {
    public int getMinSwaps(String num, int k) {
        
        char[] c = num.toCharArray();
        int n = c.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = c[i] - '0';
        }
        for (int i = 0; i < k; i++) {
            nextPermutation(a);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == c[i] - '0') {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (a[j] == c[i] - '0') {
                    for (int k1 = j; k1 > i; k1--) {
                        int t = a[k1];
                        a[k1] = a[k1 - 1];
                        a[k1 - 1] = t;
                        ans++;
                    }
                    break;
                }
            }
        }
        return ans;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
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
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}