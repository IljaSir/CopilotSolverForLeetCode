class Solution {
public:
    string largestTimeFromDigits(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        string res;
        do {
            if (arr[0] < 2 && arr[1] < 4 && arr[2] < 6) {
                res = to_string(arr[0]) + to_string(arr[1]) + ":" + to_string(arr[2]) + to_string(arr[3]);
            }
        } while (next_permutation(arr.begin(), arr.end()));
        return res;
    }
};