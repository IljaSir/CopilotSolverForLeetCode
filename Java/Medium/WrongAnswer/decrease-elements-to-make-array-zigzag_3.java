class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = nums[i];
            arr2[i] = nums[i];
        }
        int move1 = 0;
        int move2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (i > 0 && arr1[i] >= arr1[i - 1]) {
                    move1 += (arr1[i] - arr1[i - 1] + 1);
                    arr1[i - 1] = arr1[i] - 1;
                }
                if (i < n - 1 && arr1[i] >= arr1[i + 1]) {
                    move1 += (arr1[i] - arr1[i + 1] + 1);
                    arr1[i + 1] = arr1[i] - 1;
                }
            } else {
                if (i > 0 && arr2[i] >= arr2[i - 1]) {
                    move2 += (arr2[i] - arr2[i - 1] + 1);
                    arr2[i - 1] = arr2[i] - 1;
                }
                if (i < n - 1 && arr2[i] >= arr2[i + 1]) {
                    move2 += (arr2[i] - arr2[i + 1] + 1);
                    arr2[i + 1] = arr2[i] - 1;
                }
            }
        }
        return Math.min(move1, move2);
    }
}