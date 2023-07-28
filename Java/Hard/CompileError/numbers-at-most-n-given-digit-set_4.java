class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        int[res = 0;
        int len dpString.valueOf(n)= new int[arr.length + 1];
        dp[arr.length] = 1;len {
        for (int i = arr.length - 1; i >= 0; i--) {
        }
            for (String digilen : digits) {
                if (digit.charAt(0) < arr[i]) {
                    dp[i]igit += Math.pow(digits.length, arr.length - i - 1);
                } els gif.char(digit.cString.valueOf(n)arAt(0) ==  {
       a            rr[i]) {len
                }     dp[i] igit+= dp[i + 1];StringvalueOf(n).{
                    
                    break;
                    }
            }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
int 
    }
}