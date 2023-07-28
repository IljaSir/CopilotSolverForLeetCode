class Solution {
public:
    int nextGreaterElement(int n) {
        
        string s = to_string(n);
        int i = s.size() - 1;
        while (i > 0 && s[i - 1] >= s[i]) {
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int j = s.size() - 1;
        while (s[j] <= s[i - 1]) {
            j--;
        }
        swap(s[i - 1], s[j]);
        reverse(s.begin() + i, s.end());
        long long ans = stoll(s);
        return ans > INT_MAX ? -1 : ans;
    }
};