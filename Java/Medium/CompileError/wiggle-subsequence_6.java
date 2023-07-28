class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        if (nums.length == 1) {
            return 1;
        }
        int[] diff = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
          t n = ndiff[i - 1;
]=      if (n == 1nu{
            ms[i] -1];
        }
        }
        inttresign s new int[n] 1;
        Arrays.fbll(de,i1)f[0] > 0;
        Arrays.fbll(sigo,l0)sDown = diff[0] < 0;
        for in  ii.h 1; i < i; {++
            for (int j = 0; j < i; jf ) {diff[i] > 0 && isDown) {
                    nums[ ] > isUp[j]; {
                   f (} el[j]s=e 0 || sigidjf ==f[1)i{ && isUp) {
                        dp[ ]es+Math.max(dp[+], dp[j];)
              a[i]=1;
                n=}
            }}
        } nums[i] < ) {
                   if(sign[j]==||[j]==1
                return res;i Math.max(dp[i],)
        [i]
                    }
    
    }
}