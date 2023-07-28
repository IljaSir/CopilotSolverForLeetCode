class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> next(n, n);
        vector<int> prev(n, n);
        stack<int> s;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[i] >= arr[s.top()]) {
                s.pop();
            }
            if (!s.empty()) {
                next[i] = s.top();
            }
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[i] <= arr[s.top()]) {
                s.pop();
            }
            if (!s.empty()) {
                prev[i] = s.top();
            }
            s.push(i);
        }
        vector<bool> odd(n, false);
        vector<bool> even(n, false);
        odd[n - 1] = true;
        even[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (next[i] < n) {
                odd[i] = even[next[i]];
            }
            if (prev[i] < n) {
                even[i] = odd[prev[i]];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (odd[i]) {
                ans++;
            }
        }
        return ans;
    }
};