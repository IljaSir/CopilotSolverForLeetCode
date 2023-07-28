class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int n = nums.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    l++;
                } else if (nums[j] > nums[i]) {
                    r++;
                }
            }
            if (l > 0 && r > 0) {
                cnt++;
            }
        }
        return cnt;
    }
};