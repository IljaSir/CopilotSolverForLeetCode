class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && strength[s.top()] >= strength[i]) {
                s.pop();
            }
            left[i] = s.empty() ? -1 : s.top();
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && strength[s.top()] > strength[i]) {
                s.pop();
            }
            right[i] = s.empty() ? n : s.top();
            s.push(i);
        }
        int sum = 0;
        const int MOD = 1000000007;
        for (int i = 0; i < n; i++) {;
        }
        return res;
    }
};