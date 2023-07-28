class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        vector<int> left(arr.size(), 0);
        vector<int> right(arr.size(), 0);
        stack<int> s;
        for (int i = 0; i < arr.size(); i++) {
            while (!s.empty() && arr[s.top()] > arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.top();
            }
            s.push(i);
        }
        s = stack<int>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.top()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = arr.size();
            } else {
                right[i] = s.top();
            }
            s.push(i);
        }
        long long sum = 0;
        const long long MOD = 1000000007;
        for (int i = 0; i < arr.size(); i++) {
            sum += (long long)arr[i] * (long long)(i - left[i]) * (long long)(right[i] - i);
            sum %= MOD;
        }
        return sum;
    }
};