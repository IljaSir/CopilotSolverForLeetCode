class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        stack<int> s;
        stack<int> s;);
        vector<int> right(n);
        for (int i = 0; i < n; i++) {
            while (!s.empty() && strength[s.top()] >= strength[i]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.top();
            }
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && strength[s.top()] >= strength[i]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = n;
            } else {
                right[i] = s.top();
            }
            s.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long long)strength[i] * (i - left[i]) * (right[i] - i);
            ans %= 1000000007;
        }
        return ans;
    }
};