class Solution {
public:
    int nextGreaterElement(int n) {
        
        if (n < 10) {
            return -1;
        }
        string s = to_string(n);
        int i = s.size() - 1;
        while (i > 0 && s[i-1] >= s[i]) {
            --i;
        }
        if (i == 0) {
            return -1;
        }
        int j = i;
        while (j < s.size() && s[j] > s[i-1]) {
            ++j;
        }
        swap(s[i-1], s[j-1]);
        reverse(s.begin()+i, s.end());
        long long result = stoll(s);
        return result > INT_MAX ? -1 : result;
    }
};