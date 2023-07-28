class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        unordered_map<int, int> cnt;
        for (int x: nums) cnt[x]++;
        int res = 0;
        for (auto& [k, v]: cnt) {
            if (cnt.count(k + 1)) {
                res = max(res, v + cnt[k + 1]);
            }
        }
        return res;
    }
};