class Solution {
public:
    string largestTimeFromDigits(vector<int>& arr) {
        
        vector<int> v;
        sort(arr.begin(), arr.end());
        do {
            if (arr[0] * 10 + arr[1] < 24 && arr[2] < 6) {
                v.push_back(arr[0] * 10 + arr[1]);
                v.push_back(arr[2] * 10 + arr[3]);
            }
        } while (next_permutation(arr.begin(), arr.end()));
        sort(v.begin(), v.end());
        if (v.empty()) return "";
        return to_string(v.back() / 100) + to_string(v.back() / 10 % 10) + ":" + to_string(v.back() % 10) + to_string(v.back() % 100 / 10);
    }
};