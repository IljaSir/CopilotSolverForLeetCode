class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        
        int n = arr.size();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        i--;
        j--;
        if (i < n) {
            arr[j] = arr[i];
            j--;
            i--;
        }
        while (i >= 0) {
            if (arr[i] == 0) {
                arr[j] = 0;
                j--;
                arr[j] = 0;
                j--;
            } else {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }
};