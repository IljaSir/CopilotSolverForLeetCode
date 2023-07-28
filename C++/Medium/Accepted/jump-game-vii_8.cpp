class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        if (s[n - 1] == '1') {
            return false;
        }
        queue<int> q;
        q.push(0);
        int l = 0;
        int r = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (cur == n - 1) {
                return true;
            }
            l = max(cur + minJump, l);
            r = min(cur + maxJump, n - 1);
            for (int i = l; i <= r; i++) {
                if (s[i] == '0') {
                    q.push(i);
                }
            }
            l = r + 1;
        }
        return false;
    }
};