class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<string> s;
        for (int i = 0; i < nums.size(); ++i) {
            string str = to_string(nums[i]);
            reverse(str.begin(), str.end());
            s.insert(str);
        }
        return s.size();
    }
};