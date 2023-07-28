class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int sum = 0;
        int n = distance.size();
        for (int i = 0; i < n; i++) {
            sum += distance[i];
        }
        if (start > destination) {
            swap(start, destination);
        }
        int tmp = 0;
        for (int i = start; i < destination; i++) {
            tmp += distance[i];
        }
        return min(tmp, sum - tmp);
    }
};