class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        sort(arr.begin(), arr.end());
        int m = arr[(arr.size() - 1) / 2];
        sort(arr.begin(), arr.end(), [m](int a, int b) {
            return abs(a - m) == abs(b - m) ? a > b : abs(a - m) > abs(b - m);
        });
        return vector<int>(arr.begin(), arr.begin() + k);
    }
};