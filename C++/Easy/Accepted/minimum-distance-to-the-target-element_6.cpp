class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        
        int n = nums.size();
        int i = start;
        while(i >= 0 && nums[i] != target) {
            i--;
        }
        int j = start;
        while(j < n && nums[j] != target) {
            j++;
        }
        int ans = INT_MAX;
        if(i >= 0) {
            ans = min(ans, abs(i - start));
        }
        if(j < n) {
            ans = min(ans, abs(j - start));
        }
        return ans;
    }
};