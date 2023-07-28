class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int ans = -1;
        for (int i = 0; i < strs.size(); i++) {
            int j = 0;
            for (; j < strs.size(); j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == strs.size()) {
                ans = max(ans, (int)strs[i].size());
            }
        }
        return ans;
    }
    
    bool isSubsequence(string& a, string& b) {
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a[i] == b[j]) i++;
            j++;
        }
        return i == a.size();
    }
};