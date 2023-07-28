class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        std::sort(arr.begin(), arr.end(), [](int a, int b) {
            int a1 = 0, b1 = 0;
            while (a) {
                a1 += a & 1;
                a >>= 1;
            }
            while (b) {
                b1 += b & 1;
                b >>= 1;
            }
            if (a1 == b1) return a < b;
            return a1 < b1;
        });
        return arr;
    }
};