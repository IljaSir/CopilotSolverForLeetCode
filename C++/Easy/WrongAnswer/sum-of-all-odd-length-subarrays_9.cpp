class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            // Number of odd length subarrays that end at arr[i]
            int end = (i + 1) / 2;
            // Number of odd length subarrays that start at arr[i]
            int start = (n - i + 1) / 2;
            sum += (end * start) * arr[i];
        }
        return sum;
    }
};