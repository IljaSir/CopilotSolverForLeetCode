class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        for (int i = arr.size(); i > 0; i--) {
            int index = find(arr, i);
            flip(arr, index + 1);
            flip(arr, i);
            res.push_back(index + 1);
            res.push_back(i);
        }
        return res;
    }
    int find(vector<int>& arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    void flip(vector<int>& arr, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;
            i++;
        }
    }
};