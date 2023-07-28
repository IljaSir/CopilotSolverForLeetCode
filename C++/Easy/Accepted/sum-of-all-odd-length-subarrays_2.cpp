class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int left = i + 1;
            int right = n - i;
            int left_odd = left / 2;
            int left_even = (left + 1) / 2;
            int right_odd = right / 2;
            int right_even = (right + 1) / 2;
            sum += (left_odd * right_odd + left_even * right_even) * arr[i];
        }
        return sum;
    }
};