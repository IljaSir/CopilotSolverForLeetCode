class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        int l = 1, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int num : nums) {
                cnt += num <= mid;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};