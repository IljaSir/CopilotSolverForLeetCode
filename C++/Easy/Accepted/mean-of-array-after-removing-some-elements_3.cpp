class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        int n = arr.size();
        int m = n / 20;
        sort(arr.begin(), arr.end());
        double sum = 0;
        for (int i = m; i < n - m; ++i) {
            sum += arr[i];
        }
        return sum / (n - 2 * m);
    }
};