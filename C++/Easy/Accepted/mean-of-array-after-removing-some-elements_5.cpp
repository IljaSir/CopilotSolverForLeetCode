class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int l = n / 20;
        int r = n - l;
        double sum = 0;
        for (int i = l; i < r; ++i) {
            sum += arr[i];
        }
        return sum / (r - l);
    }
};