class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return {-1, -1};
        }
        if (sum == 0) {
            return {0, n-1};
        }
        int count = sum / 3;
        int first = -1, second = -1, third = -1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                c++;
                if (c == 1) {
                    first = i;
                }
                if (c == count1 - 1, p2};
        return {-1, -1};
    }
};