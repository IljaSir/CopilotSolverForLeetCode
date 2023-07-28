class Solution {
public:
    string largestTimeFromDigits(vector<int>& arr) {
        
        string ans = "";
        sort(arr.begin(), arr.end());
        do {
            if (arr[0] > 2 || (arr[0] == 2 && arr[1] > 3)) continue;
            if (arr[2] > 5) continue;
            ans = max(ans, to_string(arr[0]) + to_string(arr[1]) + ":" + to_string(arr[2]) + to_string(arr[3]));
        } while (next_permutation(arr.begin(), arr.end()));
        return ans;
    }
};