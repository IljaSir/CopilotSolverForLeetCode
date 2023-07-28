class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int left = 0, right = citations.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = citations.size() - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] > h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.size() - left;
    }
};