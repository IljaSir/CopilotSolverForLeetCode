class Solution {
public:
    string minInteger(string num, int k) {
        
        string res;
        int n = num.size(), i = 0;
        while (k && i < n) {
            int j = i;
            while (j + 1 < n && num[j + 1] >= num[j]) ++j;
            int d = min(j - i + 1, k);
            int m = i;
            for (int l = i; l <= j; ++l)
                if (num[l] < num[m]) {
                    m = l;
                    if (num[l] == '0') break;
                }
            for (int l = m; l > i; --l) swap(num[l], num[l - 1]);
            k -= m - i;
            res += num[i++];
        }
        res += num.substr(i);
        return res;
    }
};