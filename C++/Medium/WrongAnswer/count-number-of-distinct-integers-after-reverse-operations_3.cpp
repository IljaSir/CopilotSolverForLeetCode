class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int> s;
        for (auto n : nums) {
            int x = 0;
            while (n) {
                x = x * 10 + n % 10;
                n /= 10;
            }
            s.insert(x);
        }
        return s.size();
    }
};