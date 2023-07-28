class Solution {
public:
    string getHappyString(int n, int k) {
        
        vector<string> ans;
        string s;
        dfs(ans, s, n, k);
        if (ans.size() < k) return "";
        return ans[k - 1];
    }
    void dfs(vector<string>& ans, string& s, int n, int k) {
        if (s.size() == n) {
            ans.push_back(s);
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ++ch) {
            if (s.size() && s.back() == ch) continue;
            s.push_back(ch);
            dfs(ans, s, n, k);
            s.pop_back();
        }
    }
};