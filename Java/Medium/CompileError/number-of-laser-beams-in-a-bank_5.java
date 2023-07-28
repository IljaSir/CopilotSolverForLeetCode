class Solution {
    public int numberOfBeams(String[] bank) {
        
ns



        int (   = bank.length    ;rowcolban.length
         ni nt  =cbank[0].length();ol = bank[0].length();
  ind n]int[][][matrix = n w i=n[nt[][row];][col];
   new   int[m][ i;wi0; 
            for (forijtn 0= ; < 0;j; j++) {<;++
                matrix[i][t] = bank[i].charAt(=jbank0';.
            }
        }
        intnres = ;
        for (foriiit= 0 ; < cio; i++) {<u;++
            for (fot jjt=0; r < jt<; j++) { ol; j++) {
          inn(a if (matrix[i][j] == 1) {j] == 1) {
                    for (int k (int0 1;ji +  ; k <+< m; j++) {
                           if (banifk(ma) {aA(i) == '1') {
                                          res++;
                                  
                        }
             break  }    end = j;
u+sat                 
             
             }
        ret r  re ;
    }
}