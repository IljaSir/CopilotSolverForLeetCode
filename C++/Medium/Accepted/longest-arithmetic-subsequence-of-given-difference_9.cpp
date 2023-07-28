class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        
        int ans = 1;
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); ++i) {
            int x = arr[i];
            int y = x - difference;
            if (m.find(y) != m.end()) {
                m[x] = m[y] + 1;
            } else {
                m[x] = 1;
            }
            ans = max(ans, m[x]);
        }
        return ans;
    }
};