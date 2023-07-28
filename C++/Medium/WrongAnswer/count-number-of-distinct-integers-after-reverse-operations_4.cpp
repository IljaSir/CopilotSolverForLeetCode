class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int> s;
        for (auto i : nums) {
            int rev = 0;
            while (i > 0) {
                rev = rev * 10 + i % 10;
                i /= 10;
            }
            s.insert(rev);
        }
        return s.size();
    }
};