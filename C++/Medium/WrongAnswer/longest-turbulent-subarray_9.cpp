class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        int maxLen = 1;
        int start = 0;
        int end = 1;
        bool flag = true;
        while (end < n) {
            if (arr[end] > arr[end - 1]) {
                if (flag) {
                    end++;
                } else {
                    start = end - 1;
                    end++;
                }
                flag = true;
            } else if (arr[end] < arr[end - 1]) {
                if (!flag) {
                    end++;
                } else {
                    start = end - 1;
                    end++;
                }
                flag = false;
            } else {
                start = end;
                end++;
            }
            maxLen = max(maxLen, end - start);
        }
        return maxLen;
    }
};