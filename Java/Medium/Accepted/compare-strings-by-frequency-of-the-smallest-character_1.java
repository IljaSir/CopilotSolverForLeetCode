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
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (q[i] < w[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
    public int f(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return count[i];
            }
        }
        return 0;
    }
}