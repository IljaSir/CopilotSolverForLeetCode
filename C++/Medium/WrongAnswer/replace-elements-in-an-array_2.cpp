class Solution {
public:
    vector<int> arrayChange(vector<int>& nums, vector<vector<int>>& operations) {
        
        unordered_map<int, int> m;
        for (const auto &op : operations) {
            ++m[op[0]];
            --m[op[1]];
        }
        int count = 0;
        for (auto &p : m) {
            count += p.second;
            p.second = count;
        }
        vector<int> res(nums.size());
        for (int i = 0; i < nums.size(); ++i) {
            res[i] = m[nums[i]];
        }
        return res;
    }
};