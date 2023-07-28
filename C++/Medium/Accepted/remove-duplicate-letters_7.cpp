class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        string result;
        vector<int> last(26, -1);
        vector<bool> visited(26, false);
        for (int i = 0; i < s.length(); ++i) {
            last[s[i] - 'a'] = i;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (visited[s[i] - 'a']) {
                continue;
            }
            while (!result.empty() && s[i] < result.back() && last[result.back() - 'a'] > i) {
                visited[result.back() - 'a'] = false;
                result.pop_back();
            }
            result.push_back(s[i]);
            visited[s[i] - 'a'] = true;
        }
        return result;
    }
};