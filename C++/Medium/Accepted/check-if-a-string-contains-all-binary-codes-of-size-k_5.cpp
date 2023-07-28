class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.size();
        if (n < k) return false;
        int cnt = 1 << k;
        vector<bool> vis(cnt, false);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur = (cur << 1) + (s[i] - '0');
        }
        vis[cur] = true;
        cnt--;
        for (int i = k; i < n; i++) {
            cur = ((cur << 1) + (s[i] - '0')) & ((1 << k) - 1);
            if (vis[cur] == false) {
                vis[cur] = true;
                cnt--;
                if (cnt == 0) return true;
            }
        }
        return false;
    }
};