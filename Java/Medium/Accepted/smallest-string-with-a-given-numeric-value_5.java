class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        int i = n - 1;
        while (k > 0) {
            int delta = Math.min(k, 25);
            res[i--] += delta;
            k -= delta;
        }
        return new String(res);
    }
}