class Solution {
    public int nextGreaterElement(int n) {
        
        char[] c = String.valueOf(n).toCharArray();
        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) i--;
        if (i < 0) return -1;
        int j = c.length - 1;
        while (c[j] <= c[i]) j--;
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        Arrays.sort(c, i + 1, c.length);
        long res = Long.parseLong(new String(c));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}