class Solution {
public:
    int maxUniqueSplit(string s) {
        
        unordered_set<string> seen;
        return dfs(s, 0, seen);
    }
    
    int dfs(string& s, int i, unordered_set<string>& seen) {
        if (i == s.size()) return 0;
        int ans = 0;
        string cur;
        for (int j = i; j < s.size(); ++j) {
            cur.push_back(s[j]);
            if (seen.count(cur)) continue;
            seen.insert(cur);
            ans = max(ans, 1 + dfs(s, j + 1, seen));
            seen.erase(cur);
        }
        return ans;
    }
};