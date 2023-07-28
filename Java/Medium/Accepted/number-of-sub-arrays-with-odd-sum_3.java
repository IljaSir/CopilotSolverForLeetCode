class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int sum = 0;
        int result = 0;
        int odd = 0;
        int even = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                result += even;
                odd++;
            } else {
                result += odd;
                even++;
            }
            result %= 1000000007;
        }
        return result;
    }
}