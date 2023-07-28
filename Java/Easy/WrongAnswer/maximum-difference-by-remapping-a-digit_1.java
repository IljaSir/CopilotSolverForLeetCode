class Solution {
    public int minMaxDifference(int num) {
        
        String s = String.valueOf(num);
        int[] a = new int[10];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - '0']++;
        }
        int max = 0;
        int min = 0;
        int p = 1;
        for (int i = 9; i >= 0; i--) {
            while (a[i] > 0) {
                max += i * p;
                p *= 10;
                a[i]--;
            }
        }
        p = 1;
        for (int i = 0; i < 10; i++) {
            while (a[i] > 0) {
                min += i * p;
                p *= 10;
                a[i]--;
            }
        }
        return max - min;
    }
}