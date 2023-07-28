class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int odd = 0, even = 1, sum = 0, res = 0;
        for (int num : arr) {
            sum += num;
            if ((sum & 1) == 1) {
                res = (res + even) % 1000000007;
                odd++;
            } else {
                res = (res + odd) % 1000000007;
                even++;
            }
        }
        return res;
    }
}