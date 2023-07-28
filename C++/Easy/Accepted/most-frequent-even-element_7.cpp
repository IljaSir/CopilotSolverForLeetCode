class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        vector<int> cnt(100001);
        for (int n: nums) {
            if (n % 2 == 0) {
                cnt[n]++;
            }
        }
        int maxcnt = 0;
        int ans = -1;
        for (int i = 0; i < 100001; i++) {
            if (cnt[i] > maxcnt) {
                maxcnt = cnt[i];
                ans = i;
            }
        }
        return ans;
    }
};