class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> s;
        int res = 0;
        for (int i : nums) {
            s.insert(i);
        }
        for (int i : nums) {
            if (s.find(i) == s.end()) {
                continue;
            }
            int len = 1;
            s.erase(i);
            int l = i - 1;
            while (s.find(l) != s.end()) {
                len++;
                s.erase(l);
                l--;
            }
            int r = i + 1;
            while (s.find(r) != s.end()) {
                len++;
                s.erase(r);
                r++;
            }
            res = max(res, len);
        }
        return res;
    }
};