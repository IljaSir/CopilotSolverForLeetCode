class Solution {
    public long countVowels(String word) {
        
        long count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i)))
                count += word.length() - i;
        }
        return count;
    }
}