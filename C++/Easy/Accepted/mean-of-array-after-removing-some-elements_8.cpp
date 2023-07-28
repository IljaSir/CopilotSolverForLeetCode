class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        int n = arr.size();
        double sum = 0;
        int i = 0.05 * n;
        sort(arr.begin(), arr.end());
        for (int j = i; j < n - i; j++) {
            sum += arr[j];
        }
        return sum / (n - 2 * i);
    }
};