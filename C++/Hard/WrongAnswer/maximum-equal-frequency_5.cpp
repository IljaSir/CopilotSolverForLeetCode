class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(n+1, 0);
        unordered_map<int, int> mp;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            mp[nums[i]]++;
            cnt[mp[nums[i]]]++;
            if (cnt[mp[nums[i]]] * mp[nums[i]] == i+1) {
                ans = i+1;
            }
            if (cnt[mp[nums[i]]] * mp[nums[i]] == i) {
                ans = i;
            }
            if (i > 0 && cnt[1] == i) {
                ans = i;
            }
            if (i > 0 && cnt[i+1] == 1 && cnt[1] * (i+1) == i) {
                ans = i+1;
            }
        }
        return ans;
    }
};