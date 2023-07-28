class Solution {
    public int getMinSwaps(String num, int k) {
        
        char[] numArray = num.toCharArray();
        char[] sortedNum = num.toCharArray();
        Arrays.sort(sortedNum);
        for (int i = 0; i < k; i++) {
            nextPermutation(sortedNum);
        }
        int swaps = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] != sortedNum[i]) {
                for (int j = i + 1; j < numArray.length; j++) {
                    if (numArray[j] == sortedNum[i]) {
                        for (int k = j; k > i; k--) {
                            char temp = numArray[k];
                            numArray[k] = numArray[k - 1];
                            numArray[k - 1] = temp;
                            swaps++;
                        }
                        break;
                    }
                }
            }
        }
        return swaps;
    }
    
    public void nextPermutation(char[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(char[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}