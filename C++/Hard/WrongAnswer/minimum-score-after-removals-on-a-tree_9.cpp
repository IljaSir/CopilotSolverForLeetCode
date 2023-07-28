class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        vector<int> parents(nums.size());
        iota(parents.begin(), parents.end(), 0);
        function<int(int)> find = [&](int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        };
        function<void(int, int)> merge = [&](int x, int y) {
            parents[find(x)] = find(y);
        };
        for (const auto& e : edges) {
            merge(e[0], e[1]);
        }
        unordered_map<int, vector<int>> groups;
        for (int i = 0; i < nums.size(); ++i) {
            groups[find(i)].push_back(nums[i]);
        }
        int ans = INT_MAX;
        for (const auto& [_, group] : groups) {
            int sum = accumulate(group.begin(), group.end(), 0);
            int x = 0;
            for (int num : group) {
                x ^= num;
            }
            ans = min(ans, sum - 2 * x);
        }
        return ans;
    }
};