class Solution {
    public int getMinSwaps(String num, int k) {
        
        int[] a = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            a[i] = num.charAt(i) - '0';
        }
        int[] b = new int[num.length()];
        for (int i = 0; i < k; i++) {
            nextPermutation(a);
        }
        for (int i = 0; i < num.length(); i++) {
            b[i] = a[i];
        }
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            if (a[i] == b[i]) {
                continue;
            }
            int j = i + 1;
            while (a[j] != b[i]) {
                j++;
            }
            while (j > i) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
                ans++;
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
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}