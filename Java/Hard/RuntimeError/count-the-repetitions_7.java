class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        int[] countArr = new int[s1.length() + 1];
        int[] nextIndexArr = new int[s1.length() + 1];
        while (i < n1) {
            for (int k = 0; k < s1.length(); k++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        count++;
                    }
                }
            }
            i++;
            countArr[i] = count;
            nextIndexArr[i] = j;
            for (int k = 0; k < i; k++) {
                if (nextIndexArr[k] == j) {
                    int prefixCount = countArr[k];
                    int patternCount = (countArr[i] - countArr[k]) * ((n1 - k) / (i - k));
                    int suffixCount = countArr[k + (n1 - k) % (i - k)] - countArr[k];
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        return count / n2;
    }
}