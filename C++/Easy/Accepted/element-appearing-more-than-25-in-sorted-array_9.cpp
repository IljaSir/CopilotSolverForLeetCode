class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        
        int N = arr.size();
        int count = 1;
        int i = 0;
        while (i < N) {
            int j = i + 1;
            while (j < N && arr[i] == arr[j]) {
                count++;
                j++;
            }
            if (count > N / 4) {
                return arr[i];
            }
            i = j;
            count = 1;
        }
        return -1;
    }
};