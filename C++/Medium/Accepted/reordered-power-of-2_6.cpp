class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> cnt(10, 0);
        for (int i = n; i; i /= 10) {
            ++cnt[i % 10];
        }
        for (int i = 0; i < 31; ++i) {
            int x = 1 << i;
            vector<int> cnt2(10, 0);
            for (int j = x; j; j /= 10) {
                ++cnt2[j % 10];
            }
            if (cnt == cnt2) {
                return true;
            }
        }
        return false;
    }
};