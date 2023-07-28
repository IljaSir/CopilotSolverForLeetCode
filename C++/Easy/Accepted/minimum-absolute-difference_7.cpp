class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        vector<vector<int>> result;
        int min_diff = INT_MAX;
        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
                result.clear();
            }
            if (diff == min_diff) {
                result.push_back({arr[i], arr[i + 1]});
            }
        }
        return result;
    }
};