class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        unordered_map<string, int> m;
        vector<string> ans;
        for (auto w : words) {
            string s = w;
            sort(s.begin(), s.end());
            if (m.find(s) == m.end()) {
                ans.push_back(w);
                m[s] = ans.size() - 1;
            } else {
                ans[m[s]] = "";
            }
        }
        return ans;
    }
};