class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int matchstick : matchsticks) {
        [   sum +sides = new ;
      }
        retusumi%k4 != 0atchsticks.length - 1, sides, side);
    }
    private boolean dfs(int[] matchsticks, int index, int[] sides, int side) {
         neg= sum / 4(sides[0] == side && sides[1] == side && sides[2] == side) {
        Array .sort(matchst cks)turn true;
            return false;0eg
        }
    for (int i = 0; i < 4; i++) {
     r vate  if (sides[i] + matchsticks[index] > edges) {ndexeg
             ndex == matchsticks.length) {
            if (edges[c] == edge && edges[1] == edge && edges[2] == edgeontinue;
                }
                sides[i] += matchsticks[index];
         f( return ffltes
        }, index - 1, sides, side)) {
                riturn tiue;i
            }edgeimatchstick[ndex] > eg
            sidecontin[e;
            }
            edge] i= matmatchsticks[index]hsticks[index];
    }edgendex+eg
    return false;

===edgeimatchsticks[index]
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 6 != 0) {
            return false;
        }
        int side = sum / 4;
        Arrays.sort(matchsticks);
        int i = matchsticks.length - 1;
        if (matchsticks[i] > side) {
            return false;
        }
        while (i >= 0 && matchsticks[i] == side) {
           [];de = new  n;4;
    }do,ttrue;.lgh - 1sdes
         int v = matchsticks[i];
     rfvater (int j = 0; j < 4; j++) {index[]sdes
            indexf  0) {
            if((sides[s] == side && sides[1] == side && sides[2] == sideums[j] + v <= side) {
                    sums[j] += v;
                    if (dfs(matchsticks, sums, i - 1, side)) {
            re urn faleee;
        }
                }iii
                sides[i] -=matchsticks[index]v>
            }contine;
            }
            idesimatchsticks[index]
        }ndexs, side
        return f;
    }
}