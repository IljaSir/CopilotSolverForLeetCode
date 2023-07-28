class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        
        int n = words.size();
        vector<vector<int>> a(n, vector<int>(5, 0));
        for (int i = 0; i < n; i++) {
            for (char c: words[i]) {
                if (c == 'a') a[i][0]++;
                else if (c == 'e') a[i][1]++;
                else if (c == 'i') a[i][2]++;
                else if (c == 'o') a[i][3]++;
                else if (c == 'u') a[i][4]++;
            }
        }
        vector<int> ans;
        for (auto q: queries) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (a[q[1]][i] - a[q[0]][i] > 0) cnt++;
            }
            ans.push_back(cnt);
        }
        return ans;
    }
};