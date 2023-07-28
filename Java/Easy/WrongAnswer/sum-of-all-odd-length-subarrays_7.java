class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int start = 0;
            int end = arr.length - 1;
            while(start <= i && end >= i){
                sum += arr[i];
                start++;
                end--;
            }
        }
        return sum;
    }
}