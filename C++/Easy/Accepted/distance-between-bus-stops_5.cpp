class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int n = distance.size();
        if (n == 0) return 0;
        if (start == destination) return 0;
        if (start > destination) swap(start, destination);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += distance[i];
        }
        int total = 0;
        for (int i = start; i < destination; i++) {
            total += distance[i];
        }
        return min(total, sum - total);
    }
};