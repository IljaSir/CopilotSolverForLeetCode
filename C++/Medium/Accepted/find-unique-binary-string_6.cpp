class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        string ans = "";
        for (int i = 0; i < n; i++) {
            ans += '0';
        }
        unordered_set<string> s;
        for (int i = 0; i < n; i++) {
            s.insert(nums[i]);
        }
        for (int i = 0; i < (1 << n); i++) {
            string cur = "";
            int num = i;
            for (int j = 0; j < n; j++) {
                cur += (num & 1) + '0';
                num >>= 1;
            }
            if (s.find(cur) == s.end()) {
                return cur;
            }
        }
        return ans;
    }
};