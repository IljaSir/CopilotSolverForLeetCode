class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        char[] chars = num.toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < n; i++) {
            pos[chars[i] - '0'] = i;
        }
        for (int i = 0; i < n && k > 0; i++) {
            for (int d = 0; d < 10; d++) {
                if (pos[d] > i && pos[d] - i <= k) {
                    for (int j = pos[d]; j > i; j--) {
                        char t = chars[j];
                        chars[j] = chars[j - 1];
                        chars[j - 1] = t;
                        pos[chars[j] - '0'] = j;
                        pos[chars[j - 1] - '0'] = j - 1;
                    }
                    k -= pos[d] - i;
                    break;
                }
            }
        }
        return new String(chars);
    }
}