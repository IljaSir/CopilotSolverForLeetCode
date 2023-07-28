class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int n = nums.size();
        int left = 1, right = 1e9;
        while(left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i = 0; i < n; ++i) {
                cnt += (nums[i] - 1) / mid;
            }
            if(cnt > maxOperations) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
};