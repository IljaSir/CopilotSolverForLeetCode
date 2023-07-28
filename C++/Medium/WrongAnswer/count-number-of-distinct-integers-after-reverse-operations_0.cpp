class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int> s;
        for (int n : nums) {
            int rev = 0;
            while (n) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            s.insert(rev);
        }
        return s.size();
    }
};