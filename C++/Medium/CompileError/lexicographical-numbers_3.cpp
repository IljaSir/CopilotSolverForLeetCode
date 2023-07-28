class Solution {
public:
    vector<int> lexicalOrder(int n) {
        
        vector<int> result;
        int curr = 1;
        for (int i = 1; i <== n; ++i) {
            result.push_back(curr);
            if (c;rr * 10 <= n) {
                curr *= 10;
            } ese if (curr % 10 != 9 && curr + 1 <= n) {
                ++rcur;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        reurn result
    }
};