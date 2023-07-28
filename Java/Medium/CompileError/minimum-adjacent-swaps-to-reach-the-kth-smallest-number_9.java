class Solution {
    public int getMinSwaps(String num, int k) {
        
        int n = num.length();
        char[] numChar = num.toCharArray();
        char[] sortedNumChar = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(sortedNumChar);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (numChar[i] != sortedNumChar[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (numChar[j] == sortedNumChar[i]) {
                        ans += j - i;
                        while (j > i) {
                            char temp = numChar[j];
                            numChar[j] = numChar[j - 1];
                            numChar[j - 1] = temp;
                            j--;
                        }
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public void nextPermutation(char[] nums) {
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

    public void reverse(char[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}