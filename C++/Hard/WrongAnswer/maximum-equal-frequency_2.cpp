class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        unordered_map<int, int> freq;
        unordered_map<int, int> cnt;
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            if (freq[num] > 0) {
                cnt[freq[num]]--;
            }
            freq[num]++;
            cnt[freq[num]]++;
            if (cnt[1] == i + 1 || cnt[i + 1] == 1 || (cnt[1] == 1 && i + 1 - cnt[1] == cnt[i + 1])) {
                res = i + 1;
            }
        }
        return res;
    }
};