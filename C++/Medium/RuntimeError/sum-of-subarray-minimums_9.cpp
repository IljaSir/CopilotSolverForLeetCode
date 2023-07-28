class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int size = arr.size();
        vector<int> left(size, 1);
        vector<int> right(size, 1);
        
        stack<pair<int, int>> s;
        for (int i = 0; i < size; i++) {
            int count = 1;
            while (!s.empty() && s.top().first > arr[i]) {
                count += s.top().second;
                s.pop();
            }
            s.push({arr[i], count});
            left[i] = count;
        }
        
        while (!s.empty()) s.pop();
        for (int i = size - 1; i >= 0; i--) {
            int count = 1;
            while (!s.empty() && s.top().first >= arr[i]) {
                count += s.top().second;
                s.pop();
            }
            s.push({arr[i], count});
            right[i] = count;
        }
        
        int sum = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < size; i++) {
            sum = (sum + (arr[i] * left[i] * right[i]) % mod) % mod;
        }
        return sum;
    }
};