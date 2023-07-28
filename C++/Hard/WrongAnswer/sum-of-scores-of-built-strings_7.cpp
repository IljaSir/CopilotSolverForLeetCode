class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.size();
        long long ans = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            ans += j - max(s.find(s[i], i + 1), s.rfind(s[j], j - 1));
        }
        return ans;
    }
};