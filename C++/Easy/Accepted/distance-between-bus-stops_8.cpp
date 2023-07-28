class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int n = distance.size();
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot += distance[i];
        }
        int s = min(start, destination);
        int d = max(start, destination);
        int sum = 0;
        for (int i = s; i < d; i++) {
            sum += distance[i];
        }
        return min(sum, tot - sum);
    }
};