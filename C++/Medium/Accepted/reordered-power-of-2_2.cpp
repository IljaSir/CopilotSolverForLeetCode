class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> cnt(10);
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int num = 1 << i;
            vector<int> cnt2(10);
            while (num > 0) {
                cnt2[num % 10]++;
                num /= 10;
            }
            if (cnt == cnt2) {
                return true;
            }
        }
        return false;
    }
};