class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int result = 0;
        int arr[3] = {a, b, c};
        std::sort(arr, arr+3);
        if (arr[1] + arr[0] <= arr[2]) {
            result = arr[0] + arr[1];
        } else {
            result = (arr[0] + arr[1] + arr[2]) / 2;
        }
        return result;
    }
};