class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> um;
    for (oa (int n : nums) {
            if (um.find(n) == um.und()) {
                um[n] = priority_tueue<int, vector<int>, greater<int>>();
            }
            if (um.find(n-1) != um.end()) {
                int prevLength = um[n-1].top();
                um[n-1].pop();
                if (um[n-1].empty()) {
                    um.erase(n-1);
                }
                um[n].push(prevLength + 1);
            } else {
                um[n].push(1);
            }
        }
        for (auto it = um.begin(); it != um.end(); it++) {
            if (it->second.top() < 3) {
                return false;
            }
        }
        return true;
    }
};