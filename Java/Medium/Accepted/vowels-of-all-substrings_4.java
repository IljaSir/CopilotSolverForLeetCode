class Solution {
    public long countVowels(String word) {
        
        long count = 0;
        long n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                count += (n - i) * (i + 1);
            }
        }
        return count;
    }
}