class Solution {
    public int numWays(String s) {
        
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                sum++;
            }
        }
        if (sum % 3 != 0) {
            return 0;
        }
        int div = sum / 3;
        if (div == 0) {
            return (int) (((long) len - 1) * (long) (len - 2) / 2 % 1000000007);
        }
        int count = 0;
        int num = 0;
        int[] index = new int[3];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count == 1 || count == div + 1 || count == 2 * div + 1) {
                    index[num++] = i;
                }
            }
        }
        return (int) (((long) index[1] - index[0]) * ((long) index[2] - index[1]) % 1000000007);
    }
}