class Solution {
    public int percentageLetter(String s, char letter) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return (int) Math.floor((count * 100.0) / s.length());
    }
}