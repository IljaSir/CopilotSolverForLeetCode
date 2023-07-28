class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int t = n * 0.05;
        double sum = 0;
        for (int i = t; i < n - t; ++i) {
            sum += arr[i];
        }
        return sum / (n - 2 * t);
    }
};