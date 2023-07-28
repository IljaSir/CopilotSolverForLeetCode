class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int odd = 0;
        int even = 1;
        int sum = 0;
        int result = 0;
        for (int n : arr) {
            sum += n;
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