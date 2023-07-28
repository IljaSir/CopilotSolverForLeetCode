class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        int n = candidates.size();
        vector<int> bits(30, 0);
        for (int c : candidates) {
            for (int i = 0; i < 30; ++i) {
                if (c & (1 << i)) {
                    bits[i]++;
                }
            }
        }
        
        int ans = 0;
        for (int i = 29; i >= 0; --i) {
            if (bits[i] > 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
};