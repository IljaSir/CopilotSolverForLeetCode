class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> cnt;
        unordered_map<int, pair<int, int>> loc;
        int max_cnt = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (loc.count(nums[i])) {
                loc[nums[i]].second = i;
                ++cnt[nums[i]];
            } else {
                loc[nums[i]] = {i, i};
                cnt[nums[i]] = 1;
            }
            max_cnt = max(max_cnt, cnt[nums[i]]);
        }
        int ans = nums.size();
        for (auto& p : loc) {
            if (cnt[p.first] == max_cnt) {
                ans = min(ans, p.second.second - p.second.first + 1);
            }
        }
        return ans;
    }
};