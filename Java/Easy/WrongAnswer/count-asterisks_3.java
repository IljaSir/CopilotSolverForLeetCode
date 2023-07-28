class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                i++;
                while (s.charAt(i) != '|') {
                    if (s.charAt(i) == '*') {
                        count++;
                    }
                    i++;
                }
            }
        }
        return count;
    }
}