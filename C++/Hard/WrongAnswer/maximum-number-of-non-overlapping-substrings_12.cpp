class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<string> result;
        vector<int> start(26, INT_MAX);
        vector<int> end(26, INT_MIN);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            start[s[i] - 'a'] = min(start[s[i] - 'a'], i);
            end[s[i] - 'a'] = max(end[s[i] - 'a'], i);
        }
        vector<bool> visited(26, false);
        for (int i = 0; i < n; i++) {
            if (visited[s[i] - 'a']) {
                continue;
            }
            visited[s[i] - 'a'] = true;
            int j = i;
            int k = i;
            while (j <= k) {
                int c = s[j] - 'a';
                k = max(k, end[c]);
                j++;
            }
            for (int l = i; l <= k; l++) {
                if (start[s[l] - 'a'] < i) {
                    k = -1;
                    break;
                }
            }
            if (k != -1) {
                result.push_back(s.substr(i, k - i + 1));
                i = k;
            }
        }
        return result;
    }
};