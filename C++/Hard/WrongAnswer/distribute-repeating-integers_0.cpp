class Solution {
public:
    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }
        vector<int> freq;
        for (auto& [k, v] : count) {
            freq.push_back(v);
        }
        sort(freq.begin(), freq.end());
        sort(quantity.begin(), quantity.end(), greater<int>());
        return dfs(freq, quantity, 0, 0);
    }
    bool dfs(vector<int>& freq, vector<int>& quantity, int i, int used) {
        if (i == quantity.size()) {
            return true;
        }
        for (int j = 0; j < freq.size(); j++) {
            if (freq[j] >= quantity[i] && (used & (1 << j)) == 0) {
                freq[j] -= quantity[i];
                if (dfs(freq, quantity, i + 1, used | (1 << j))) {
                    return true;
                }
                freq[j] += quantity[i];
            }
        }
        return false;
    }
};