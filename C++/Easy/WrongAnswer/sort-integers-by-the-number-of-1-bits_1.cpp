class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        sort(arr.begin(), arr.end(), [](int a, int b) {
            int ca = 0, cb = 0;
            while (a) {
                ca += a & 1;
                a >>= 1;
            }
            while (b) {
                cb += b & 1;
                b >>= 1;
            }
            if (ca == cb) return a < b;
            return ca < cb;
        });
        return arr;
    }
};