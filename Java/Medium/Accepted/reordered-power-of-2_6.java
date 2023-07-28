class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        String s = Integer.toString(n);
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 0; i < 31; i++) {
            if (match(count, 1 << i)) {
                return true;
            }
        }
        return false;
    }
    public boolean match(int[] count, int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] != count[i]) {
                return false;
            }
        }
        return true;
    }
}