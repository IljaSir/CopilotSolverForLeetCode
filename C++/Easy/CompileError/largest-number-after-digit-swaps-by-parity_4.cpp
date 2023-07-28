class Solution {
public:
    int largestInteger(int num) {
        
        int arr[10] = {0};
        while (num) {
            arr[num%10]++;
            num /= 10;
        }
        int res = 0;
        for (int i = 9; i >= 0; --i) {
            while (arr[i]--) {
                res = res * 10 + i;
            }
        }
        return res;
    }
    int maximumSwap(int num) {
        int arr[10] = {0};
        int pos[10] = {0};
        int pos2[10] = {0};
        int n = 0;
        while (num) {
            arr[n] = num % 10;
            pos[n] = n;
            pos2[n] = n;
            num /= 10;
            ++n;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (arr[i] == j) continue;
                if (arr[i] % 2 == j % 2) {
                    if (pos[j] > i) {
                        swap(arr[i], arr[pos[j]]);
                        int res = largestInteger(arr, n);
                        swap(arr[i], arr[pos[j]]);
                        return res;
                    }
                }
            }
        }
        return largestInteger(arr, n);
    }
};