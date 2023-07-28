class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        vector<int> ans(2);
        unordered_map<string, int> mp;
        for (auto &s : words) {
            string key = "";
            for (auto &c : s) {
                key += to_string((c - s[0] + 26) % 26) + ",";
            }
            mp[key]++;
        }
        for (auto &p : mp) {
            ans[0] = max(ans[0], p.second);
            ans[1] = max(ans[1], (int)p.first.size());
        }
        return ans;
    }
};