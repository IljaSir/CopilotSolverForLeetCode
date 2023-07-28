class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        vector<int> left(n
        vector<int> left(n);
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
            } else {;
        }
        return sum;
    }
};