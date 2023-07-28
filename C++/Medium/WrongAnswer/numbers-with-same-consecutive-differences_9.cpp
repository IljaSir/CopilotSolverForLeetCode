class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> ans;
        for (int i = 1; i <= 9; i++) {
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int x = q.front();
                q.pop();
                if (x < 10 && x >= 0 && x >= i - k && x <= i + k) {
                    if (x >= 10) {
                        ans.push_back(x);
                    } else if (n == 1) {
                        ans.push_back(x);
                    } else {
                        q.push(x * 10 + i - k);
                        q.push(x * 10 + i + k);
                    }
                }
            }
        }
        return ans;
    }
};