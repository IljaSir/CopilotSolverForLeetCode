class Solution {
public:
    int maxUniqueSplit(string s) {
        
        int ans = 0;
        unordered_set<string> us;
        dfs(s, 0, us, ans);
        return ans;
    }
    
    void dfs(string& s, int idx, unordered_set<string>& us, int& ans) {
        if (idx == s.size()) {
            ans = max(ans, (int)us.size());
            return;
        }
        
        string str;
        for (int i = idx; i < s.size(); ++i) {
            str.push_back(s[i]);
            if (us.count(str)) continue;
            us.insert(str);
            dfs(s, i + 1, us, ans);
            us.erase(str);
        }
    }
};