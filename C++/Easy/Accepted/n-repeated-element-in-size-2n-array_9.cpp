class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        
        map<int, int> m;
        for (auto& n : nums) {
            if (m[n] > 0) return n;
            m[n]++;
        }
        return 0;
    }
};