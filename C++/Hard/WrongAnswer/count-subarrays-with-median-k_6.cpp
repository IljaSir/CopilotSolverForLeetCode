class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int median = 0;
            int odd = 0;
            for(int j = i; j < n; j++) {
                median += nums[j] >= k;
                odd += (j - i + 1) % 2 == 1;
                if(median == odd) {
                    ans++;
                }
            }
        }
        return ans;
    }
};