class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        int l = arr.size() / 20;
        double sum = 0;
        for (int i = l; i < arr.size() - l; i++) {
            sum += arr[i];
        }
        return sum / (arr.size() - 2 * l);
    }
};