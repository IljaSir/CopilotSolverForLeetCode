class Solution {
    public int maxPalindromes(String s, int k) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd > k) {
            return 0;
        }
        if (odd == k) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] / 2 >= k) {
                ans++;
                k = 0;
                break;
            } else if (count[i] / 2 > 0) {
                k -= count[i] / 2;
                ans++;
            }
        }
        return ans;
    }
}