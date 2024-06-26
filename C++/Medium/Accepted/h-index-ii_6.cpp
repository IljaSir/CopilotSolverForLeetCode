class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int n = citations.size();
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (citations[mid] >= n - mid) r = mid;
            else l = mid + 1;
        }
        return n - l;
    }
};