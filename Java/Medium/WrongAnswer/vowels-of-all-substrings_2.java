class Solution {
    public long countVowels(String word) {
        
        int n = word.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                ans += (i + 1) * (n - i);
            }
        }
        return ans;
    }
}