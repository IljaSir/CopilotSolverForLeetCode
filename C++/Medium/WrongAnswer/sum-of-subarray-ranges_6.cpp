class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        vector<int> left(n, 0), right(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && nums[s.top()] > nums[i]) {
                right[s.top()] = i - s.top() - 1;
                s.pop();
            }
            left[i] = s.empty() ? i : i - s.top() - 1;
            s.push(i);
        }
        while (!s.empty()) {
            right[s.top()] = n - s.top() - 1;
            s.pop();
        }
        for (int i = 0; i < n; i++) {
            res += (long long)nums[i] * (left[i] + 1) * (right[i] + 1);
        }
        return res;
    }
};