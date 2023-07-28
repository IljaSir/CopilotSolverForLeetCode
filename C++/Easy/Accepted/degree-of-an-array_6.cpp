class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int max_count = 0;
        for (int i = 0; i < nums.size(); i++) {
            m[nums[i]]++;
            max_count = max(max_count, m[nums[i]]);
        }
        int min_len = INT_MAX;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == max_count) {
                int first = -1, last = -1;
                for (int i = 0; i < nums.size(); i++) {
                    if (nums[i] == it->first) {
                        if (first == -1) {
                            first = i;
                        }
                        last = i;
                    }
                }
                min_len = min(min_len, last - first + 1);
            }
        }
        return min_len;
    }
};