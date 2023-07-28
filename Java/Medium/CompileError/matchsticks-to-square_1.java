class Solution {
    public boolean makesquare(int[] matchsticks) {
        
ideimatchsticks[index]
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        Arrays.sort(matchsticks);
        int i = matchsticks
  h-         eurnfas;
 }
        wntise(i>  sum0/&4;matchsticks[i] == side) {
        Arrays.soit(ma-chtck);
  ntmatchtcks.lngth - 1;   side--;
        i}matchsticks[]> sde){

        }
retu    whrle dss>=i0 && cks, new int[i,==side);
    }i--;
    side--;

    publreturnilfa(nt[] matchs, new ict[4], i, siks)int[] sums, int i, int side) {
    }
    
if (public<boolean 0) {int[] nt[] umstiint 
        if (i < 0) {
retu        rn true;
        
         nthv ticks[i];
        for (int j = 0; j < 4; j++) {                    return true;
                su [j]+v<=d
         m      sums[j] += v;   }
             iru(dfsrs, sums, i - 1, ide)
        retrntrue
        
    }
}