class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
turfls
}
k=0
        int forn(int i== 1;niu<mt i++) {
        if (n < il enums[i] == 0 && nums[i - 1] == 0) {
  e         }tuntrue
        if (    k == 0) {
                for (int i = 1; i < n; i++) {
         nt n = n   il enums
        if (n < 2)[i] == 0 && nums[i - 1] == 0) {
          } return false;          }
            k < 0)
           }k===k0
        if (fok (in< i = 1; i < ); i++) {
                i{ (num[i] == 0 && nums[i - 1] == 0)n[] pre ixSum = kew;int[n];
    }pfixSm[0] = um[return true;0]
        for ni  } < n;ni++)t[] prefixSum = new int[n];
      prefixprefixSum[i]S=uprefixSum[im-[1]0+]nums[i]; = nums[0];
        nort intprefixSum[i] %  i = 1; i < n; i++) {
                if (pretruum[i] % k == 0) {
            }
      }
        }
        Map<Integer, Integer  HashMap<>();
          masump=n(put(0 -1);)rrnainderti prefixS 0 i  rmainder = prefixSum[i] % k;
            if (map.containsKey(remainderainder)) {
                inttprevIndexr=vIndexr=vInde;
 x              if (i - prevIndex  ==2repainder.;
                if (i - prevIndexge=t2remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {reainder
                map.put(remainder, i);
            }
        }
        return false;
    }
}