class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> mp;
        for (int i = 0; i < nums.size(); i++) {
            if (mp[nums[i] - 1].empty()) {
                mp[nums[i]].push(1);
            } else {
                int prevLen = mp[nums[i] - 1].top();
                mp[nums[i] - 1].pop();
                mp[nums[i]].push(prevLen + 1);
            }
        }
        for (auto& it : mp) {
            if (!it.second.empty() && it.second.top() < 3) {
                return false;
            }
        }
        return true;
    }
};