class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        map<int, int> cnt;
        for (auto num : nums) {
            cnt[num] += 1;
        }
        int res = 0;
        for (auto it = cnt.begin(); it != cnt.end(); ++it) {
            auto jt = it;
            ++jt;
            if (jt != cnt.end() && jt->first == it->first + 1) {
                res = max(res, jt->second + it->second);
            }
        }
        return res;
    }
};