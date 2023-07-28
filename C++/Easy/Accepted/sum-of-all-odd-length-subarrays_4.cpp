class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - i;
            int leftOdd = (l + 1) / 2;
            int leftEven = l / 2;
            int rightOdd = (r + 1) / 2;
            int rightEven = r / 2;
            sum += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];
        }
        return sum;
    }
};