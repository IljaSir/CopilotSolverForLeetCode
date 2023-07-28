class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.length();
        vector<int> left(n, 0), right(n, 0);
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            int l = i, r = i;
            while (l >= 0 && r < n && s[l] == s[r]) {
                left[i] = r - l + 1;
                l--;
                r++;
            }
            l = i, r = i + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                left[i] = max(left[i], r - l + 1);
                l--;
                r++;
            }
            l = j, r = j;
            while (l >= 0 && r < n && s[l] == s[r]) {
                right[j] = r - l + 1;
                l--;
                r++;
            }
            l = j, r = j + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                right[j] = max(right[j], r - l + 1);
                l--;
                r++;
            }
        }
        long long res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = max(res, (long long)left[i] * right[i + 1]);
        }
        return res;
    }
};