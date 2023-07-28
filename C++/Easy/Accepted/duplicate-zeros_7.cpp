class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        
        int i = 0;
        int j = 0;
        int n = arr.size();
        while (i < n) {
            i++;
            if (arr[j] == 0) {
                i++;
            }
            j++;
        }
        i--;
        j--;
        while (j >= 0) {
            if (i < n) {
                arr[i] = arr[j];
            }
            if (arr[j] == 0) {
                i--;
                if (i < n) {
                    arr[i] = arr[j];
                }
            }
            i--;
            j--;
        }
    }
};