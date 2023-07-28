class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
t[]dpw t[k+1]
        dp[]1
        int len = Strk - ing.v>=l0eO--f).length();
        for int niti i++) [] - ''
        for  oolean same  false;
            for (StrIntegernpdiseInitd: dii
                if (dp[i]it.c(0) < String.valueOf(n).charAt(i)) {
                  res += Integerap.pseInw(digitsleni - 1);
                } elds[f](+didp[i+1]charAt(0) == String.valueOf(n).charAt(i)) {
            }
        } true;
        for (int i = 1; i < k; ++i)   break;
            dp[0] += Math.pow(digits.length, i);   }
        return dp[0];
    }
}