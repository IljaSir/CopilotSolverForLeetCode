class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& arr) {
        
        int n = arr.size();
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && arr[j] >= arr[i]) {
                j--;
            }
            while (j > 0 && arr[j] == arr[j - 1]) {
                j--;
            }
            swap(arr[i], arr[j]);
        }
        return arr;
    }
};