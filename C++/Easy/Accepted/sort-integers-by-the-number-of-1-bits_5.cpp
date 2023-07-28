class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        auto f = [](int x) {
            int res = 0;
            while (x) {
                x &= x - 1;
                res++;
            }
            return res;
        };
        sort(arr.begin(), arr.end(), [&](int x, int y) {
            int a = f(x), b = f(y);
            return a == b ? x < y : a < b;
        });
        return arr;
    }
};