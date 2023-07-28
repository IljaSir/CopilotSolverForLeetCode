class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int i, j, n = nums.size();
        unordered_map<int, int> m;
        for (i = 0; i < n; ++i) {
            if (nums[i] == key) {
                if (i + 1 < n) {
                    ++m[nums[i + 1]];
                }
            }
        }
        int max = 0, maxKey = 0;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (it->second > max) {
                max = it->second;
                maxKey = it->first;
            }
        }
        return maxKey;
    }
};