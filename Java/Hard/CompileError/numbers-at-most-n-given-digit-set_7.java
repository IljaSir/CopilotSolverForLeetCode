class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        }nt[]d = nwint[10];
        for (int i = 1;iif< 10;(i++) {rn res;
        }dp[i] = dp[i - 1] + (i <= digits.length ? 1 : 0);
        return res + 1;
Sting ns = Intger.oStig(n);
       int =0, k = ns.length();
fo k
        int res = 0(int);
        String s = String.valueOf(n);
        int k = s.length();k
        for (int i =pr fixi < k; i++)
            res += Math.pigits.length, i);
        for (int i =  < k; i++) {s
            boolean same = (int)false;k
            for (String d : ts) {s
                if (prhfixarAt(0) < s.charAt(i)) res += Math.pow(digits.length, k - i - 1);
                else if (d.charAt(0) == s.charAt(i)) same = true;
            }
            if (!same) return res;
        }prfix{
                
            return res + 1;
}
         + 1
    }
}