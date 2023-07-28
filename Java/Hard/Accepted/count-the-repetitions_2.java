class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        int[] rep = new int[s2.length() + 1];
        int[] next = new int[s2.length() + 1];
        int j = 0, count = 0;
        for (int k = 1; k <= n1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        count++;
                    }
                }
            }
            rep[k] = count;
            next[k] = j;
            for (int start = 0; start < k; start++) {
                if (next[start] == j) {
                    int prefixCount = rep[start];
                    int patternCount = (rep[k] - rep[start]) * ((n1 - start) / (k - start));
                    int suffixCount = rep[start + (n1 - start) % (k - start)] - rep[start];
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        return rep[n1] / n2;
    }
}