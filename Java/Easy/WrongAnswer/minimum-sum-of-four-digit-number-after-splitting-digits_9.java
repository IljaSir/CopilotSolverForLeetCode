class Solution {
    public int minimumSum(int num) {
        
        int[] arr = new int[10];
        while(num > 0) {
            arr[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for(int i = 1; i < 10; i++) {
            if(arr[i] > 0) {
                sum += i;
                arr[i]--;
                break;
            }
        }
        for(int i = 0; i < 10; i++) {
            if(arr[i] > 0) {
                sum += i * Math.pow(10, arr[i]);
            }
        }
        return sum;
    }
}