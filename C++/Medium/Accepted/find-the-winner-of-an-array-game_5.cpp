class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        if (k >= n) {
            return *max_element(arr.begin(), arr.end());
        }
        int i = 0;
        int j = 1;
        int win = 0;
        while (win < k) {
            if (arr[i] > arr[j]) {
                win++;
                j++;
                if (j == n) {
                    j = 0;
                }
            } else {
                win = 1;
                i = j;
                j++;
                if (j == n) {
                    j = 0;
                }
            }
        }
        return arr[i];
    }
};