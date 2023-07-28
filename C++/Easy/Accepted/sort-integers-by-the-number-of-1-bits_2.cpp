class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        vector<int> bits(10001);
        bits[0] = 0;
        for (int i = 1; i < bits.size(); i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        sort(arr.begin(), arr.end(), [&](int a, int b) {
            return bits[a] == bits[b] ? a < b : bits[a] < bits[b];
        });
        return arr;
    }
};