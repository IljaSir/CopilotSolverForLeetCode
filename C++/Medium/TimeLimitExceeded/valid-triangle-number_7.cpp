class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int k = j + 1;
                while(k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }
};