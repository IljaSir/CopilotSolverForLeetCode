class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& arr) {
        
        int i = arr.size() - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = i + 1;
        while (j + 1 < arr.size() && arr[j + 1] < arr[i]) {
            j++;
        }
        int k = j;
        while (k + 1 < arr.size() && arr[k + 1] == arr[j]) {
            k++;
        }
        swap(arr[i], arr[k]);
        return arr;
    }
};