class Solution {
public:
    int maxUniqueSplit(string s) {
        
        unordered_set<string> set;
        return dfs(s, 0, set);
    }
    int dfs(string& s, int start, unordered_set<string>& set) {
        if (start == s.size()) return set.size();
        int res = 0;
        for (int i = start; i < s.size(); i++) {
            string t = s.substr(start, i - start + 1);
            if (set.count(t)) continue;
            set.insert(t);
            res = max(res, dfs(s, i + 1, set));
            set.erase(t);
        }
        return res;
    }
};