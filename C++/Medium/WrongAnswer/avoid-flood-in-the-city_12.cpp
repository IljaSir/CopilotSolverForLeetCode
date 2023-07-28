class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        vector<int> ans(rains.size(), 1);
        unordered_map<int, int> full;
        priority_queue<int, vector<int>, greater<int>> dry;
        for (int i = 0; i < rains.size(); ++i) {
            if (rains[i] == 0) dry.push(i);
            else {
                if (full.find(rains[i]) != full.end()) {
                    if (dry.empty()) return {};
                    int j = dry.top();
                    dry.pop();
                    if (j < full[rains[i]]) return {};
                    ans[j] = rains[i];
                }
                full[rains[i]] = i;
                ans[i] = -1;
            }
        }
        return ans;
    }
};