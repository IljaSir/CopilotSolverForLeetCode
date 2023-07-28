class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        
        int i = 0;
        int j = 0;
        int missing = 0;
        while (j < arr.size()) {
            if (arr[j] == i + 1) {
                ++i;
                ++j;
            } else {
                ++missing;
                ++i;
            }
            if (missing == k) {
                break;
            }
        }
        while (missing < k) {
            ++missing;
            ++i;
        }
        return i;
    }
};