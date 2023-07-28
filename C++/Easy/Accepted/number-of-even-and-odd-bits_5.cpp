class Solution {
public:
    vector<int> evenOddBit(int n) {
        
        vector<int> result;
        int even = 0;
        int odd = 0;
        int i = 0;
        while (n > 0) {
            if (n & 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n >>= 1;
            i++;
        }
        result.push_back(even);
        result.push_back(odd);
        return result;
    }
};