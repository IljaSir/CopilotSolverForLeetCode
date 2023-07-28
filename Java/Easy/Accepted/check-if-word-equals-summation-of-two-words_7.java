class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < firstWord.length(); i++){
            a += firstWord.charAt(i)-'a';
            a *= 10;
        }
        a /= 10;
        for(int i = 0; i < secondWord.length(); i++){
            b += secondWord.charAt(i)-'a';
            b *= 10;
        }
        b /= 10;
        for(int i = 0; i < targetWord.length(); i++){
            c += targetWord.charAt(i)-'a';
            c *= 10;
        }
        c /= 10;
        return a+b == c;
    }
}