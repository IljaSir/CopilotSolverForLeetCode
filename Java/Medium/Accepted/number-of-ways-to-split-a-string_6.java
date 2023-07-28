class Solution {
    public int numWays(String s) {
        
        int ones = 0;
        int mod = 1000000007;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        if (ones == 0) {
            long n = s.length() - 1;
            return (int) ((n * (n - 1) / 2) % mod);
        }
        if (ones % 3 != 0) return 0;
        int target = ones / 3;
        int count = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
            if (count == target) left++;
            if (count == target * 2) right++;
        }
        return (int) ((long) left * right % mod);
    }
}