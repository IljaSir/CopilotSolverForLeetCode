class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> ans;
        int n = words.size();
        if (n == 0) return ans;
        int m = words[0].size();
        if (m == 0) return ans;
        unordered_map<string, int> mp;
        for (auto& word : words) {
            mp[word]++;
        }
        for (int i = 0; i < m; i++) {
            unordered_map<string, int> cur;
            int cnt = 0;
            for (int j = i; j <= s.size() - m; j += m) {
                string curWord = s.substr(j, m);
                if (mp.find(curWord) == mp.end()) {
                    cur.clear();
                    cnt = 0;
                } else {
                    cur[curWord]++;
                    cnt++;
                    while (cur[curWord] > mp[curWord]) {
                        string leftWord = s.substr(j - (cnt - 1) * m, m);
                        cur[leftWord]--;
                        cnt--;
                    }
                    if (cnt == n) {
                        ans.push_back(j - (n - 1) * m);
                    }
                }
            }
        }
        return ans;
    }
};