class Solution {
    public int countVowelSubstrings(String word) {
        
        int n = word.length();
        int[] cnt = new int[5];
        int ans = 0;
        for (char c : word.toCharArray()) {
            int i = "aeiou".indexOf(c);
            cnt[i] = 1 + (i > 0 ? cnt[i - 1] : 0);
            ans += cnt[i];
        }
        return ans;
    }
}