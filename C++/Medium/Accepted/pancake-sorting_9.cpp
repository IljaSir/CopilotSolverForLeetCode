class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        int n = arr.size();
        int maxIndex = 0;
        for(int i = n - 1; i > 0; i--) {
            maxIndex = findMax(arr, i);
            if(maxIndex != i) {
                flip(arr, maxIndex);
                res.push_back(maxIndex + 1);
                flip(arr, i);
                res.push_back(i + 1);
            }
        }
        return res;
    }
    int findMax(vector<int>& arr, int i) {
        int maxIndex = 0;
        for(int j = 0; j <= i; j++) {
            if(arr[j] > arr[maxIndex]) {
                maxIndex = j;
            }
        }
        return maxIndex;
    }
    void flip(vector<int>& arr, int i) {
        int l = 0, r = i;
        while(l < r) {
            swap(arr[l++], arr[r--]);
        }
    }
};