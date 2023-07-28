class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return n;
        int ans = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
};