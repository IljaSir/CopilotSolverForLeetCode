class Solution {
public:
    int maxUniqueSplit(string s) {
        
        unordered_set<string> dict;
        return dfs(s, 0, dict);
    }
    
    int dfs(string& s, int start, unordered_set<string>& dict) {
        if (start == s.length()) return 0;
        int res = 0;
        for (int i = start; i < s.length(); ++i) {
            string str = s.substr(start, i - start + 1);
            if (dict.count(str)) continue;
            dict.insert(str);
            res = max(res, 1 + dfs(s, i + 1, dict));
            dict.erase(str);
        }
        return res;
    }
};