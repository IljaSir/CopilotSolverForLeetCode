class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> s;
        for (auto &n: nums) {
            s.insert(n);
        }
        int max = 0;
        for (auto &n: nums) {
            if (s.find(n-1) == s.end()) {
                int cur = n;
                int curMax = 1;
                while (s.find(cur+1) != s.end()) {
                    cur++;
                    curMax++;
                }
                if (curMax > max) {
                    max = curMax;
                }
            }
        }
        return max;
    }
};