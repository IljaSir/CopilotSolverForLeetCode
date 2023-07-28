class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        int mod = 0;
        for(int i=0;i<n;i++){
            mod += nums[i];
            mod %= p;
        }
        if(mod == 0) return 0;
        int ans = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        for(int i=0;i<n;i++){
            curr += nums[i];
            curr %= p;
            map.put(curr, i);
            int need = (curr - mod + p) % p;
            if(map.containsKey(need)){
                ans = Math.min(ans, i - map.get(need));
            }
        }
        if(ans == n) return -1;
        return ans;
    }
}