class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] f = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            f[i] = f(words[i]);
        }
        Arrays.sort(f);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = f(queries[i]);
            res[i] = f.length - binarySearchSmaller(f, q);
        }
        return res;
    }

    int binarySearchSmaller(int[] f, int q) {
        int l = 0, r = f.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (f[m] <= q) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    int f(String s) {
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < c) {
                c = s.charAt(i);
                count = 1;
            } else if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}