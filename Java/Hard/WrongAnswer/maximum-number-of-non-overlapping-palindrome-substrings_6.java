class Solution {
    public int maxPalindromes(String s, int k) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int odd = 0;
        for (int i = 0; i < 26; i++)
            if (count[i] % 2 == 1)
                odd++;

        return Math.min(odd, s.length() - k);
    }
}