class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        
        int[] res = new int[queries.length];
        
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (q[i] < w[j]) {
                    res[i]++;
                }
            }
        }
        
        return res;
    }
    
    private int f(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return freq[i];
            }
        }
        
        return 0;
    }
}