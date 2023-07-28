class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int l = 0, r = 0;
        int cnt = 0;
        while(r < n){
            if(nums[r] == 0) cnt++;
            while(cnt > 1){
                if(nums[l] == 0) cnt--;
                l++;
            }
            ans = max(ans, r-l);
            r++;
        }
        return ans;
    }
};