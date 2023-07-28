class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        string res = "";
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            res += "0";
        }
        for (int i = 0; i < n; i++) {
            if (nums[i][i] == '0') {
                res[i] = '1';
            }
        }
        return res;
    }
};