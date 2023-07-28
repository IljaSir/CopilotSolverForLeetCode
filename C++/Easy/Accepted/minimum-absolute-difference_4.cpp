class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        int min = INT_MAX;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }
        vector<vector<int>> result;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                result.push_back({arr[i], arr[i + 1]});
            }
        }
        return result;
    }
};