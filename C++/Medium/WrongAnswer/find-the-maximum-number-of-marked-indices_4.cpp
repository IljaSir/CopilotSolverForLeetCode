class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] <= 2 * nums[ans]) {
                ans++;
            } else {
                ans = i + 1;
            }
        }
        return ans;
    }
};