class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        if (nums.size() < 3) return 0;
        sort(nums.begin(), nums.end());
        int count = 0;
        for (int i = 0; i < nums.size() - 2; i++) {
            for (int j = i + 1; j < nums.size() - 1; j++) {
                int k = j + 1;
                while (k < nums.size() && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }
};