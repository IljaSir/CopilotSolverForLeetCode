class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int i = 0;
        int j = n - 1;
        while (i < n && s[i] == '0') i++;
        while (j >= 0 && s[j] == '0') j--;
        if (i >= j) return 0;
        int ans = 2;
        for (int k = i; k <= j; k++) {
            if (s[k] == '1') {
                ans += 2;
                while (k <= j && s[k] == '1') k++;
            }
        }
        return ans;
    }
};