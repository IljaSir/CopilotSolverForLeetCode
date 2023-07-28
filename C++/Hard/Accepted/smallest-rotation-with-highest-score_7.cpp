class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> score(n, 0);
        for (int i = 0; i < n; ++i) {
            int l = (i - nums[i] + 1 + n) % n;
            int r = (i + 1) % n;
            score[l]--;
            score[r]++;
            if (l > r) {
                score[0]--;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            score[i] += score[i - 1];
            if (score[i] > score[ans]) {
                ans = i;
            }
        }
        return ans;
    }
};