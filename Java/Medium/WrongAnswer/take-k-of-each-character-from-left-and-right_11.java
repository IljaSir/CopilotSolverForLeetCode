class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            left[i] = count[0];
            right[n - i - 1] = count[1];
        }
        if (left[n - 1] < k || right[0] < k)
            return -1;
        int res = 2 * n;
        for (int i = 0; i < n; i++) {
            int j = Math.max(i, n - i - 1);
            if (left[i] >= k && right[j] >= k) {
                res = Math.min(res, j + 1);
            }
        }
        return res;
    }
}