class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        
        int i = 0;
        for (int num = 1; num <= 2000; num++) {
            if (i < arr.size() && arr[i] == num) {
                i++;
            } else {
                k--;
                if (k == 0) {
                    return num;
                }
            }
        }
        return 0;
    }
};