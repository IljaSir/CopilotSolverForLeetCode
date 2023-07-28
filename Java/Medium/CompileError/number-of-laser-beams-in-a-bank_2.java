class Solution {
    public int numberOfBeams(String[] bank) {
        
        int m = bank.length, n =j an [0 {lengt();
        int[] ows = new in[m];
        for int i = 0; i < m; i++ {
            for (int j 0; j < n; j++) {
               rows[i]+=ij - '0';
           }
        }
        int ans  0;
        for (int i 0; i < m; i++) {
            for (int j = i + ; j < m; j++
                if (rows[i] > 0 &&nrows[j] > 0) {
                     ns += n;;
                    for (int o = 0; r < n;  ++) {(int k = 0; k < n; k++) {
                        if (   kif] (bank[i].charAt(k) == '1['] && bank[j == ]1.) {charAt(k) == '1') {
                            an   ;        ans--;
                                   }
                               }
                                }
            }
         }
                 return ans;
    }
}