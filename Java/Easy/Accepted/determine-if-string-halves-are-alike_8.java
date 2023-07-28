class Solution {
    public boolean halvesAreAlike(String s) {
        
        int size = s.length();
        int half = size / 2;
        int count = 0;
        for (int i = 0; i < half; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        for (int i = half; i < size; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count--;
            }
        }
        return count == 0;
    }
}