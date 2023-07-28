class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        
        unordered_set<int> s;
        for (auto n : nums) {
            if (s.find(n) != s.end()) {
                return n;
            } else {
                s.insert(n);
            }
        }
        return -1;
    }
};