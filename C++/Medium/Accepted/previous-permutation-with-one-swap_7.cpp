class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& arr) {
        
        int n = arr.size();
        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i == 0) {
            return arr;
        }
        int j = n - 1;
        while (j >= i && arr[j] >= arr[i - 1]) {
            j--;
        }
        int k = j;
        while (k >= i && arr[k] == arr[j]) {
            k--;
        }
        swap(arr[i - 1], arr[k + 1]);
        return arr;
    }
};