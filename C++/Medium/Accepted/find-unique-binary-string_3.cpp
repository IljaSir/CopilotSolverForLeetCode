class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        int i = 0;
        for (auto s: nums) {
            if (s[i] == '0') {
                s[i] = '1';
            } else {
                s[i] = '0';
            }
            if (find(nums.begin(), nums.end(), s) == nums.end()) {
                return s;
            }
            i = (i + 1) % n;
        }
        return "";
    }
};