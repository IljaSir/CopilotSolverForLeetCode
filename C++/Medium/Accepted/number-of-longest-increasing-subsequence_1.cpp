class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return n;
        vector<int> len(n, 1), cnt(n, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }
        int longest = *max_element(len.begin(), len.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (len[i] == longest) {
                ans += cnt[i];
            }
        }
        return ans;
    }
};