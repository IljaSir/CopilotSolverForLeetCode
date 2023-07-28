class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int> s;
        for (auto n : nums) {
            int r = 0;
            while (n) {
                r = r * 10 + n % 10;
                n /= 10;
            }
            s.insert(r);
        }
        return s.size();
    }
};