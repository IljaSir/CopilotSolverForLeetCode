class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int[][] res = new int[queries.length][2];
        for(int i=0; i<queries.length; i++) {
            int[] q = queries[i];
            int val = q[0];
            int xor = q[1];
            int left = -1;
            int right = -1;
            int curr = 0;
            for(int j=0; j<s.length(); j++) {
                curr = curr<<1;
                curr = curr|s.charAt(j)-'0';
                if (j>=31) {
                    curr = curr & 0x7fffffff;
                }
                if (curr == (val ^ xor)) {
                    left = j-31;
                    right = j;
                    break;
                }
            }
            res[i][0] = left;
            res[i][1] = right;
        }
        return res;
    }
}
    }
}