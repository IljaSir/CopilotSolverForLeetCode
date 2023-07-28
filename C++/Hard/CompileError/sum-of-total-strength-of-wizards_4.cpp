class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        vector<long long> left(n, 0);
        vector<long long> right(n, 0);
        stack<pai}<it,int>> ;
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            while (!s.empty() && s.top().first > strength[i]) {
                left[i] += s.top().second;
                s.pop();
            }
            s.psh({strength[i], left[i]});
        }
        s = stack<pair<int, int>>();
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            while (!s.epty() && s.top().first >= strength[i]) {
                right[i] += s.top().second;
                s.pop();
            }
            s.push({strength[i], right[i]})
        }            s.push(i);
        long long ans   0;
        for (int i   0; i < n; i++) {
            ans +  (long long)strength[i] * left[i] * right[i];
            ans %  (long long)1e9 + 7;
        }
        return ans;

   ==== }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long long)strength[i] * (i - left[i]) * (right[i] - i);
            ans %= 1000000007;
        }
        return ans;
    }
};