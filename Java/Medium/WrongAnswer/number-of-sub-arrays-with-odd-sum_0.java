class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int odd = 0;
        int even = 1;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                res += odd;
                even++;
            } else {
                res += even;
                odd++;
            }
        }
        return res % 1000000007;
    }
}