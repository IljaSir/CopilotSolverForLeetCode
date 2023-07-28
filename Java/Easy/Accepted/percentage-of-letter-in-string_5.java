class Solution {
    public int percentageLetter(String s, char letter) {
        
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return (int) (100 * count / (double) s.length());
    }
}