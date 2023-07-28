class Solution {
    public String minInteger(String num, int k) {
        
        char[] chars = num.toCharArray();
        int n = chars.length;
        int[] pos = new int[10];
        for (int i = 0; i < n; i++) {
            pos[chars[i] - '0'] = i;
        }
        for (int i = 0; i < n && k > 0; i++) {
            for (int d = 0; d < 10; d++) {
                if (pos[d] > i && pos[d] - i <= k) {
                    k -= pos[d] - i;
                    for (int j = pos[d]; j > i; j--) {
                        chars[j] = chars[j - 1];
                    }
                    chars[i] = (char) ('0' + d);
                    for (int j = d; j < 10; j++) {
                        pos[j]--;
                    }
                    break;
                }
            }
        }
        return new String(chars);
    }
}