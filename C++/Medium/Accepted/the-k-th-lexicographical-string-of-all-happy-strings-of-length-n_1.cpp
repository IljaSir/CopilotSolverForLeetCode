class Solution {
public:
    string getHappyString(int n, int k) {
        
        string ans;
        dfs(ans, n, k);
        return ans;
    }
    void dfs(string& ans, int n, int& k) {
        if (ans.size() == n) {
            --k;
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ++ch) {
            if (ans.empty() || ans.back() != ch) {
                ans.push_back(ch);
                dfs(ans, n, k);
                if (k == 0) {
                    return;
                }
                ans.pop_back();
            }
        }
    }
};