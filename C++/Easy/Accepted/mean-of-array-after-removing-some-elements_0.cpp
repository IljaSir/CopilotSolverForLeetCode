class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        double sum = 0;
        for (int i = n / 20; i < n - n / 20; ++i) {
            sum += arr[i];
        }
        return sum / (n - n / 10);
    }
};