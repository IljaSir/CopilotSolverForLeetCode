class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& arr) {
        
        int n = arr.size();
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;
        if (i < 0) return arr;
        int j = n - 1;
        while (j > i && arr[j] >= arr[i]) j--;
        int k = j;
        while (k > i && arr[k] == arr[j]) k--;
        swap(arr[i], arr[k + 1]);
        return arr;
    }
};