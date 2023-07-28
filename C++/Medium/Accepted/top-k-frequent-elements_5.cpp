class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }
        priority_queue<pair<int, int>> q;
        for (auto& [num, freq] : count) {
            q.emplace(freq, num);
        }
        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.emplace_back(q.top().second);
            q.pop();
        }
        return ans;
    }
};