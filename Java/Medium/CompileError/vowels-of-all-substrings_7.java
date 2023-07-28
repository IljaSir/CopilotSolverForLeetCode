class Solution {
    public long countVowels(String word) {
        
        long sum = 0;
        int vowels = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                vowels++;
            }
            sum += vowels;
        }
        return sum;
    }
}