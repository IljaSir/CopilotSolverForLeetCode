class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        int n = nums.size();
        unordered_set<int> s;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int rev = 0;
            while (num > 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            s.insert(rev);
        }
        return s.size();
    }
};