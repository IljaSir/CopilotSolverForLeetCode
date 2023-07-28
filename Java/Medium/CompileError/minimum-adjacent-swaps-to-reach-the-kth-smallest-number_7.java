class Solution {
    public int getMinSwaps(String num, int k) {
        
        String target = num;
        while (k-- > 0) {
            target = nextPermutation(target);
        }
        int n = num.length();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = target.indexOf(num.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (pos[i] != i) {
                swap(pos, i, pos[i]);
                ans++;
            }
        }
        return ans;
    }

    private String nextPermutation(String s) {
        int n = s.length();
        int i = n - 2;
        while (i >= 0 && s.charAt(i) >= s.charAt(i + 1)) {
            i--;
        }
        if (i < 0) {
            return s;
        }
        int j = n - 1;
        while (j >= 0 && s.charAt(j) <= s.charAt(i)) {
            j--;
        }
        s = swap(s, i, j);
        return s.substring(0, i + 1) + new StringBuilder(s.substring(i + 1)).reverse().toString();
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }
}