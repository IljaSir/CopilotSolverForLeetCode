class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        
        vector<vector<int>> res;
        sort(arr.begin(), arr.end());
        int min = INT_MAX;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                res.push_back(vector<int>{arr[i], arr[i + 1]});
            }
        }
        return res;
    }
};