class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        if (n == 0) return 0;
        if (n == 1) {
            if (citations[0] == 0) return 0;
            else return 1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (citations[m] == n - m) return n - m;
            else if (citations[m] < n - m) l = m + 1;
            else r = m - 1;
        }
        return n - l;
    }
};