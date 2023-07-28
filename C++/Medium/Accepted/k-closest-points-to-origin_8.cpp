class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        vector<vector<int>> result;
        priority_queue<pair<int, vector<int>>> maxHeap;
        for (auto & point: points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            maxHeap.push({distance, point});
            if (maxHeap.size() > k) {
                maxHeap.pop();
            }
        }
        while (!maxHeap.empty()) {
            result.push_back(maxHeap.top().second);
            maxHeap.pop();
        }
        return result;
    }
};