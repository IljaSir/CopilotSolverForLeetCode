class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        vector<vector<int>> result;
        int min = INT_MAX;
        for (int i = 1; i < arr.size(); i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < min) {
                min = diff;
                result.clear();
                result.push_back({arr[i - 1], arr[i]});
            } else if (diff == min) {
                result.push_back({arr[i - 1], arr[i]});
            }
        }
        return result;
    }
};