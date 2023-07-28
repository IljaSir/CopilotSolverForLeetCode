class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        vector<int> cnt(n+1, 0);
        int num = 0;
        int l = 0, r = 0;
        while(r < n) {
            if(cnt[nums[r]] == 0) {
                num++;
            }
            cnt[nums[r]]++;
            r++;
            while(num > k) {
                cnt[nums[l]]--;
                if(cnt[nums[l]] == 0) {
                    num--;
                }
                l++;
            }
            int l2 = l;
            while(cnt[nums[l2]] > 1) {
                cnt[nums[l2]]--;
                l2++;
            }
            res += l2 - l + 1;
        }
        return res;
    }
};