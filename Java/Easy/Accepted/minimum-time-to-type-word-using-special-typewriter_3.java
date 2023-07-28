class Solution {
    public int minTimeToType(String word) {
        
        int pos = 0;
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            result += Math.min(Math.abs(c - pos), 26 - Math.abs(c - pos)) + 1;
            pos = c;
        }
        return result;
    }
}