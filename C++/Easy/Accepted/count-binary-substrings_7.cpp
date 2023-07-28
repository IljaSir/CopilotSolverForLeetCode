class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int n = s.size();
        vector<int> count;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            count.push_back(j - i);
            i = j;
        }
        int ans = 0;
        for (int i = 1; i < count.size(); i++) {
            ans += min(count[i], count[i - 1]);
        }
        return ans;
    }
};