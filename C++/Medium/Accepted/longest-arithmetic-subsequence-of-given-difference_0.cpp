class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int a : arr) {
            m[a] = m[a - difference] + 1;
            res = max(res, m[a]);
        }
        return res;
    }
};