class Solution {
public:
    string getHappyString(int n, int k) {
        
        vector<string> happy;
        string s;
        for (int i = 0; i < n; i++) {
            s += 'a';
        }
        dfs(s, 0, happy);
        if (happy.size() >= k) {
            return happy[k - 1];
        }
        return "";
    }
    
    void dfs(string& s, int start, vector<string>& happy) {
        if (start == s.size()) {
            happy.push_back(s);
            return;
        }
        for (char c = 'a'; c <= 'c'; c++) {
            if (start > 0 && s[start - 1] == c) {
                continue;
            }
            s[start] = c;
            dfs(s, start + 1, happy);
        }
    }
};