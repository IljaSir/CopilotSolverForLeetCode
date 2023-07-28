class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int[] c = count.clone();
            for (char ch : Integer.toString(1 << i).toCharArray()) {
                c[ch - '0']--;
            }
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                if (c[j] != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }
}