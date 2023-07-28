class Solution {
public:
    int maxVowels(string s, int k) {
        
        int n = s.length();
        vector<int> v(n, 0);
        if (s[0] == 'a' || s[0] == 'e' || s[0] == 'i' || s[0] == 'o' || s[0] == 'u') {
            v[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                v[i] = v[i - 1] + 1;
            } else {
                v[i] = v[i - 1];
            }
        }
        int maxV = v[k - 1];
        for (int i = 1; i < n - k + 1; i++) {
            maxV = max(maxV, v[i + k - 1] - v[i - 1]);
        }
        return maxV;
    }
};