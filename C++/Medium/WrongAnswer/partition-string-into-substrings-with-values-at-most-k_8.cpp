class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size(), res = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && s[j - 1] <= s[j]) ++j;
            int len = j - i;
            if (len > k) return -1;
            res += (len + k - 1) / k;
            i = j;
        }
        return res;
    }
};