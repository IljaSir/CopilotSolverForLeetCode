class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> cnt(10, 0);
        while (n) {
            cnt[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int cur = 1 << i;
            vector<int> cur_cnt(10, 0);
            while (cur) {
                cur_cnt[cur % 10]++;
                cur /= 10;
            }
            if (cur_cnt == cnt) {
                return true;
            }
        }
        return false;
    }
};