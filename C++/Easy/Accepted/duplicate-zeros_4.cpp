class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        
        int len = arr.size();
        int i = 0;
        while (i < len) {
            if (arr[i] == 0) {
                for (int j = len - 1; j > i; --j) {
                    arr[j] = arr[j-1];
                }
                i += 2;
            } else {
                i++;
            }
        }
    }
};