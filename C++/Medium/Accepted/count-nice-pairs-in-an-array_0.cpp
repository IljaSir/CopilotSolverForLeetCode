class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int res = 0, mod = 1e9+7;
        for (int num : nums) {
            string s = to_string(num);
            reverse(s.begin(), s.end());
            int rev = stoi(s);
            res = (res + m[num - rev]++) % mod;
        }
        return res;
    }
};