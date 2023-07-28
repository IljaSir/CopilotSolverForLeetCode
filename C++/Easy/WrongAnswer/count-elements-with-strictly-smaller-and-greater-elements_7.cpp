class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[i] == nums[j]) {
                j++;
            }
            if (j < n && nums[i] < nums[j]) {
                cnt += j - i;
            }
            i = j - 1;
        }
        return cnt;
    }
};