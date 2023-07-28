class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size(), res = 1;
        vector<int> next(n), prev(n);
        stack<int> s;
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.top()] <= arr[i]) s.pop();
            next[i] = s.empty() ? n : s.top();
            s.push(i);
        }
        while (!s.empty()) s.pop();
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.top()] >= arr[i]) s.pop();
            prev[i] = s.empty() ? n : s.top();
            s.push(i);
        }
        vector<bool> higher(n), lower(n);
        higher[n - 1] = lower[n - 1] = true;
        for (int i = n - 2; i >= 0; --i) {
            if (next[i] != n) higher[i] = lower[next[i]];
            if (prev[i] != n) lower[i] = higher[prev[i]];
            if (higher[i]) ++res;
        }
        return res;
    }
};