class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            a = a * 10 + firstWord.charAt(i) - 'a';
        }
        for (int i = 0; i < secondWord.length(); i++) {
            b = b * 10 + secondWord.charAt(i) - 'a';
        }
        for (int i = 0; i < targetWord.length(); i++) {
            c = c * 10 + targetWord.charAt(i) - 'a';
        }
        return a + b == c;
    }
}