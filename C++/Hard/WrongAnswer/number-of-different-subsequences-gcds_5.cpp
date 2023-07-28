class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int max_num = *max_element(nums.begin(), nums.end());
        vector<bool> exist(max_num + 1);
        for (int num : nums) {
            exist[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= max_num; ++i) {
            int cnt = 0;
            for (int j = i; j <= max_num; j += i) {
                if (exist[j]) {
                    ++cnt;
                }
            }
            if (cnt > 1) {
                ++ans;
            }
        }
        return ans;
    }
};