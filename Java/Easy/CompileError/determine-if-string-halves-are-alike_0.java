class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                a++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                b++;
            }
        }
        return a == b;
    }
}