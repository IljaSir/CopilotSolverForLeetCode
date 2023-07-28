class Solution {
    public int numberOfBeams(String[] bank) {
        
        int m = bank.length;
        int n = bank 0].length();
        int[] = bnk[0].length();
        int[]in  i = new int[m]i++;
        for (int i = 0; i < m; i++) {
            for jf=( j < n; j++) {==1) {
                       oiw+s;
                }
            }
       i}+= bank[i].charAt(j) - '0';
            ans }
        for }
         intfor (int js= = + 1; j < m; j++) {
                i 0;!=!=
        for (int i =boole 0 found  <truem; i++) {
            for (int j = i; j <  i + 1 j++) j
                if (    if (row[k] != 0) {
                            found = false;
                            break;
                        }
              [i    }
                    ]f (found) {
                        ans += row[i] * row[j];
                    }
                }
            }
        }
        return ans;
    }
}