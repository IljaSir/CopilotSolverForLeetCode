class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] res = new int[queries.length];
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (q[i] < w[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
    public int f(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        int count = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}