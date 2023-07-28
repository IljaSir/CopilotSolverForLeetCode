class Solution {
public:
    int maxUniqueSplit(string s) {
        
        unordered_set<string> set;
        return dfs(s, 0, set);
    }
    
    int dfs(string& s, int start, unordered_set<string>& set) {
        if (start == s.size()) {
            return 0;
        }
        int ans = 0;
        for (int i = start; i < s.size(); i++) {
            string sub = s.substr(start, i - start + 1);
            if (set.find(sub) == set.end()) {
                set.insert(sub);
                ans = max(ans, 1 + dfs(s, i + 1, set));
                set.erase(sub);
            }
        }
        return ans;
    }
};