class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int xorRes = 0;
        for (int n: nums) {
            xorRes ^= n;
        }
        int lastBit = xorRes & (-xorRes);
        int n1 = 0, n2 = 0;
        for (int n: nums) {
            if (lastBit & n) {
                n1 ^= n;
            } else {
                n2 ^= n;
            }
        }
        return {n1, n2};
    }
};