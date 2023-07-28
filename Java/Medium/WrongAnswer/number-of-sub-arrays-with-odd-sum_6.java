class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int sum = 0;
        int odd = 0;
        int even = 0;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        return (odd * (odd + 1) / 2 + even * (even + 1) / 2) % mod;
    }
}