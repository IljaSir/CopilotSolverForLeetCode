class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        int mod = 1e9 + 7;
        vector<int> nums;
        int cost = 0;
        for (int i = 0; i < n; ++i) {
            int pos = lower_bound(nums.begin(), nums.end(), instructions[i]) - nums.begin();
            cost = (cost + min(pos, (int)nums.size() - pos)) % mod;
            nums.insert(nums.begin() + pos, instructions[i]);
        }
        return cost;
    }
};