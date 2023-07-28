class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1;
        int r = 1000000000;
        while(l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for(auto &i : nums) {
                cnt += (i - 1) / mid;
            }
            if(cnt <= maxOperations) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};