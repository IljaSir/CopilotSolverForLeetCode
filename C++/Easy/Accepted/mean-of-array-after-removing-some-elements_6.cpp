class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int x = n / 20;
        double sum = 0;
        for (int i = x; i < n - x; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * x);
    }
};