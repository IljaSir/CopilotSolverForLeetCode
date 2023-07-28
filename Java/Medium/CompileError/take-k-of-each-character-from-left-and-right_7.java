class Solution {
    public int takeCharacters(String s, int k) {
        
        int[] a = new int[3];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] < k) {
                return -1;
            }
            res += a[i] / k;
        }
        return res;
    }
    public int takeCharacters2(String s, int k) {
        int n = s.length();
        int[] a = new int[3];
        int[] b = new int[3];
        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'a']++;
            b[s.charAt(n - i - 1) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] < k || b[i] < k) {
                return -1;
            }
            res += a[i] / k;
        }
        return res;
    }
    public int takeCharacters3(String s, int k) {
        int n = s.length();
        int[] a = new int[3];
        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] < k) {
                return -1;
            }
            res += a[i] / k;
        }
        return res;
    }
    public int takeCharacters4(String s, int k) {
        int n = s.length();
        int[] a = new int[3];
        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] < k) {
                return -1;
            }
            res += a[i] / k;
    }
}