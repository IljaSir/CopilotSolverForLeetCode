class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> s;
        for (int n : nums) s.insert(n);
        int ans = 0;
        for (int n : nums) {
            if (s.count(n - 1)) continue;
            int cur = n;
            int curL = 1;
            while (s.count(cur + 1)) {
                cur++;
                curL++;
            }
            ans = max(ans, curL);
        }
        return ans;
    }
};