class Solution {
    public int maximumSum(int[] nums) {
        
        int[] arr = new int[100];
        for(int i: nums) {
            int sum = 0;
            int tmp = i;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            arr[sum] = Math.max(arr[sum], i);
        }
        int max = -1;
        for(int i = 0; i < 100; i++) {
            for(int j = i + 1; j < 100; j++) {
                if(arr[i] > 0 && arr[j] > 0) {
                    max = Math.max(max, arr[i] + arr[j]);
                }
            }
        }
        return max;
    }
}