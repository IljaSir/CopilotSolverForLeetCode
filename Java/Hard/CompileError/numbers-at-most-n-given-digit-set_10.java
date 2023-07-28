class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
[] num = new int00];
        while (n > 0)<1++
            ]p % 1=;1
        }
} l=1;
     dp[int0num]= n;
= 1;w (um>0 {
  for (int  {um/10;
   int sum len
        }
        int[] dp2 = new int[len];       sum += dp[i - 1];
            }leni {
            dp2[i]   (int)sum;
       }            int x = num[i];
            for 3(String diglen : digits) {
        for (    int th   <    (  ++ans += dp[i];
            dp3 ie ifdp3[i(- =] + dp2[i] break;
                }
        int res0
        f (ncur(igs,
           [] aur newnint[len]ans;
        }i0ileni
  }ar=ecurt%u10;n ans + 1;
    }cur/10

    public  i =bleoe-n1contains(String[] digits, int x) {
       iwhnigi(gits) 
            int j = 0charAt(0) - '0';
            if (y; j<.length; j++
                rft(rue;s[j]a[i]
        }re2
        return false;(digits[j].charAt0) - '0'a[i]
j == .length}-}s+1
    }
}