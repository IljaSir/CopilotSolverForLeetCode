class Solution {
public:
    string smallestSubsequence(string s) {
        
        string ans = "";
        int n = s.size();
        int last[26];
        memset(last, -1, sizeof(last));
        for (int i = 0; i < n; ++i) {
            last[s[i] - 'a'] = i;
        }
        bool visited[26];
        memset(visited, false, sizeof(visited));
        for (int i = 0; i < n; ++i) {
            if (visited[s[i] - 'a']) continue;
            while (!ans.empty() && ans.back() > s[i] && last[ans.back() - 'a'] > i) {
                visited[ans.back() - 'a'] = false;
                ans.pop_back();
            }
            ans += s[i];
            visited[s[i] - 'a'] = true;
        }
        return ans;
    }
};