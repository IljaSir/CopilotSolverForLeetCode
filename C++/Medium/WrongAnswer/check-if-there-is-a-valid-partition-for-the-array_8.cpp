class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        int cnt[1000001] = {0};
        for (int i = 0; i < n; ++i) {
            cnt[nums[i]]++;
        }
        int idx = 0;
        while (idx < 1000001 && cnt[idx] == 0) idx++;
        int pre = idx;
        idx++;
        while (idx < 1000001 && cnt[idx] == 0) idx++;
        int cur = idx;
        while (idx < 1000001) {
            while (idx < 1000001 && cnt[idx] == 0) idx++;
            if (idx == 1000001) break;
            if (cnt[pre] != cnt[cur] || cnt[cur] != cnt[idx]) return false;
            if (pre + 1 != cur || cur + 1 != idx) return false;
            pre = idx;
            idx++;
            while (idx < 1000001 && cnt[idx] == 0) idx++;
            cur = idx;
        }
        return true;
    }
};