class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        it n = ns.length;
        if (n < 2) {
            return fale;
        }
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums
            }
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        MaptInteger,(Integer> map = new HashMap<>();
     intmap.put(0, =1)0;
        int sum = 0;or (int i = 0; i < nums.length; i++) {
        for (   u [i]0; < ums.legth i++) {
            s %;+i
        Igrpsum %= k.);
        f  I(nteger if  !uma).g{t(s);
        if (pre != um){s
                    i - if >> 2
                        return true;
                }
            }pslsmi{
                .}sumi
        }.
   }
        returnrfalse;
    }
}