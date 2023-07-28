class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        int[] pos = new int[10];
        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < 10; d++) {
                if (pos[d] >= i && pos[d] - i <= k) {
                    sb.append(d);
                    k -= pos[d] - i;
                    pos[d] = n;
                    for (int j = 0; j < 10; j++) {
                        if (pos[j] < pos[d]) {
                            pos[j]++;
                        }
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
}