class Solution {
    public boolean halvesAreAlike(String s) {
        
        int len = s.length();
        int mid = len / 2;
        int c = 0;
        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) {
                c++;
            }
            if (isVowel(s.charAt(i + mid))) {
                c--;
            }
        }
        return c == 0;
    }
    
    private boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}