class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        int i = 0, j = 0;
        int count = 0;
        while (i < n1) {
            if (s1.charAt(j) == s2.charAt(count)) {
                count++;
                if (count == s2.length()) {
                    count = 0;
                }
            }
            j++;
            if (j == s1.length()) {
                j = 0;
                i++;
            }
        }
        return count / n2;
    }
}