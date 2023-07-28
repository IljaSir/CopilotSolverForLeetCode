class Solution {
    public int makeStringSorted(String s) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans = 0;
        int mod = 1000000007;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int smaller = 0;
            for (int j = s.charAt(i) - 'a' + 1; j < 26; j++) {
                smaller += freq[j];
            }
            int fact = factorial[n - i - 1];
            ans = (ans + ((long) smaller * fact) % mod) % mod;
            for (int j = s.charAt(i) - 'a'; j < 26; j++) {
                freq[j]--;
            }
        }
        return ans;
    }

    int[] factorial = new int[3001];

    {
        factorial[0] = 1;
        for (int i = 1; i <= 3000; i++) {
            factorial[i] = (int) ((long) factorial[i - 1] * i % 1000000007);
        }
    }
}