class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int sum = 0;
        for (int i = 0; i < distance.size(); ++i) {
            sum += distance[i];
        }
        int d = 0;
        if (start <= destination) {
            for (int i = start; i < destination; ++i) {
                d += distance[i];
            }
        } else {
            for (int i = destination; i < start; ++i) {
                d += distance[i];
            }
        }
        return min(d, sum - d);
    }
};