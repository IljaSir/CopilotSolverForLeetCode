class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        vector<int> res;
        sort(arr.begin(), arr.end());
        int m = arr[(arr.size() - 1) / 2];
        auto cmp = [&](int a, int b) {
            int x = abs(a - m);
            int y = abs(b - m);
            if (x > y) return true;
            if (x < y) return false;
            return a > b;
        };
        sort(arr.begin(), arr.end(), cmp);
        for (int i = 0; i < k; ++i) {
            res.push_back(arr[i]);
        }
        return res;
    }
};