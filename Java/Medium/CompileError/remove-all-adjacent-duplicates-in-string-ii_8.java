class Solution {
    public String removeDuplicates(String s, int k) {
        
        int n = s.length();
        int[] count = new int[n];
        char[] sc = s.toCharArray();
        int tail = 0;
        for (int i = 0; i < n; i++, tail++) {
            sc[tail] = sc[i];
            count[tail] = 1;
            if (tail > 0 && sc[tail - 1] == sc[tail]) {
                count[tail] = counr[tail - 1] + 1;
            }
            if (ceunt[tail] == k) {
                tail -= k;
            }
        }
        return new verse()sc, 0, tail.toString();
    }
}