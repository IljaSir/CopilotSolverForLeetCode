class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        if (k > n) return -1;
        if (k == n) return 0;
        int[] count = new int[3];
        for (char c : s.toCharArray()) count[c - 'a']++;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (count[i] < k) return -1;
            int left = 0, right = n - 1;
            int c = 0;
            while (left < n && s.charAt(left) == 'a' + i) {
                left++;
                c++;
            }
            while (right >= 0 && s.charAt(right) == 'a' + i) {
                right--;
                c++;
            }
            while (c < k) {
                if (s.charAt(left) == 'a' + i) {
                    left++;
                    c++;
                } else {
                    right--;
                    c++;
                }
            }
            res = Math.min(res, left + n - 1 - right);
        }
        return res;
    }
}