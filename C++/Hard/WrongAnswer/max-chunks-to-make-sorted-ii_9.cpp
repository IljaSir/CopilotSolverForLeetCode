class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        vector<int> v(arr);
        sort(v.begin(), v.end());
        int n = arr.size();
        int res = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] == v[j]) {
                ++res;
                i = j = j + 1;
            } else {
                ++i;
                ++j;
            }
        }
        return res;
    }
};