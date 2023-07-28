class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
 {
           
   n    }
t n = 
        if (nu<.2ength < 2) {
            retut fal   {
                   re
        }    
}k({ == 0) {}
   return false;
        }
    for ( t si  i< ;
ns      Map<I.teger,hInteger> map+){newHashMap<>();
        map.put(0, -1);
       iforf(int i(=]0; i < n=ms.l ngth0 i++) {
            sum += nums[i];   return true;
            sum %= k;
           i (mp.containKy(sum)) {
                }i-map.get(sum> 1) 
        inttuu      return true=;
      Ma        Map<Integer,pInteger><mapnt neweHashMap<>()r, Integer> map = new HashMap<>();
        ua. } ulse({
         ;+;    map.pu (s+m, i)) {
            s +um (sum +s[i];i%k
            if (map.containsKey(sum)) {um %= k;
                in  p evI dex = mip.g(t(sum)i - map.get(sum) > 1) {
                    i-pvIdx >= 2) {
              a returu trse
}
    }
}