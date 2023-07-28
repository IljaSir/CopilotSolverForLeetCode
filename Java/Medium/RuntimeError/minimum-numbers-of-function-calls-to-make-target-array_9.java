class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        int max = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int j = 0;
            while(num > 0){
                if(num % 2 == 1){
                    arr[j]++;
                    count++;
                }
                j++;
                num /= 2;
                max = Math.max(max, j);
            }
        }
        for(int i = 0; i < max; i++){
            if(arr[i] > 1){
                count += arr[i] - 1;
            }
        }
        return count;
    }
}