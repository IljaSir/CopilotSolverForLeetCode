class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        int n = arr.size();
        int k = n / 20;
        sort(arr.begin(), arr.end());
        int sum = 0;
        for (int i = k; i < n - k; ++i) {
            sum += arr[i];
        }
        return (double)sum / (n - 2 * k);
    }
};