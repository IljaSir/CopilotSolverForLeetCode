class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n) {
            if (nums[i][i] == '1') {
                nums[i][i] = '0';
            } else {
                nums[i][i] = '1';
            }
            i++;
        }
        return nums[n-1];
    }
};