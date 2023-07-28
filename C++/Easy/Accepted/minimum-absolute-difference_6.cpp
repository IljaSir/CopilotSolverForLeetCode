class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        
        vector<vector<int>> result;
        sort(arr.begin(), arr.end());
        int min_diff = INT_MAX;
        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
                result.clear();
                result.push_back({arr[i], arr[i + 1]});
            } else if (diff == min_diff) {
                result.push_back({arr[i], arr[i + 1]});
            }
        }
        return result;
    }
};