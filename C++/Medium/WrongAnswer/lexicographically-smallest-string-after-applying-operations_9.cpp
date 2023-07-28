class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        string res = s;
        int n = s.size();
        vector<bool> vis(n);
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int j = i, k = 0;
            string t = s;
            do {
                vis[j] = true;
                if (k % 2) t[j] = (t[j] - '0' + a) % 10 + '0';
                j = (j + b) % n;
                k++;
            } while (j != i);
            res = min(res, t);
        }
        return res;
    }
};