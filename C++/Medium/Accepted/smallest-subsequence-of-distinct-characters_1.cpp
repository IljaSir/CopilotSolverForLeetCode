class Solution {
public:
    string smallestSubsequence(string s) {
        
        vector<int> last(26, 0);
        for (int i = 0; i < s.size(); i++) {
            last[s[i] - 'a'] = i;
        }
        vector<bool> visited(26, false);
        string ans = "0";
        for (int i = 0; i < s.size(); i++) {
            int x = s[i] - 'a';
            if (visited[x]) continue;
            while (s[i] < ans.back() && i < last[ans.back() - 'a']) {
                visited[ans.back() - 'a'] = false;
                ans.pop_back();
            }
            ans.push_back(s[i]);
            visited[x] = true;
        }
        return ans.substr(1);
    }
};