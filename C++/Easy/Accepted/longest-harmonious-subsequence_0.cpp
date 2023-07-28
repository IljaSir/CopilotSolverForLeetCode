class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            m[nums[i]]++;
        }
        int res = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            auto it2 = m.find(it->first + 1);
            if (it2 != m.end()) {
                res = max(res, it->second + it2->second);
            }
        }
        return res;
    }
};