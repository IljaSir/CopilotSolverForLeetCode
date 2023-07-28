class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size(), m = arr[(n - 1) / 2];
        auto cmp = [&](int a, int b) {
            return abs(a - m) > abs(b - m) || (abs(a - m) == abs(b - m) && a > b);
        };
        sort(arr.begin(), arr.end(), cmp);
        return vector<int>(arr.begin(), arr.begin() + k);
    }
};