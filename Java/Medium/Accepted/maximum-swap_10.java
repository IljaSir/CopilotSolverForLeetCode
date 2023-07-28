class Solution {
    public int maximumSwap(int num) {
        
        char[] a = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < a.length; i++) {
            last[a[i] - '0'] = i;
        }
        for (int i = 0; i < a.length; i++) {
            for (int d = 9; d > a[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = a[i];
                    a[i] = a[last[d]];
                    a[last[d]] = temp;
                    return Integer.valueOf(new String(a));
                }
            }
        }
        return num;
    }
}