class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> mp;
        for (auto n : nums) {
            if (mp.find(n - 1) == mp.end()) {
                mp[n].push(1);
            } else {
                int prevLen = mp[n - 1].top();
                mp[n - 1].pop();
                if (mp[n - 1].empty()) {
                    mp.erase(n - 1);
                }
                mp[n].push(prevLen + 1);
            }
        }
        for (auto& p : mp) {
            if (p.second.top() < 3) {
                return false;
            }
        }
        return true;
    }
};