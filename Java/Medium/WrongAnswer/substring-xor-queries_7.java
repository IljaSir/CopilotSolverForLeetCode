class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[][] result = new int[queries.length][2];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ (s.charAt(i) - '0');
        }
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int xor = first ^ second;
            int index = -1;
            for (int j = 0; j <= n; j++) {
                if (prefix[j] == xor) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                result[i][0] = -1;
                result[i][1] = -1;
            } else {
                int left = -1;
                int right = -1;
                for (int j = 0; j < index; j++) {
                    if ((prefix[j] ^ first) == second) {
                        left = j;
                        break;
                    }
                }
                for (int j = n; j > index; j--) {
                    if ((prefix[j] ^ first) == second) {
                        right = j;
                        break;
                    }
                }
                result[i][0] = left;
                result[i][1] = right;
            }
        }
        return result;
    }
}