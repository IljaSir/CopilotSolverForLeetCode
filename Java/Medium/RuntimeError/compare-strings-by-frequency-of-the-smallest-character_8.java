class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] f = new int[11];
        for (String word : words) {
            f[f(word)]++;
        }
        for (int i = 9; i >= 0; i--) {
            f[i] += f[i + 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = f[f(queries[i]) + 1];
        }
        return ans;
    }
    public int f(String s) {
        char min = s.charAt(0);
        int freq = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
                freq = 1;
            } else if (s.charAt(i) == min) {
                freq++;
            }
        }
        return freq;
    }
}