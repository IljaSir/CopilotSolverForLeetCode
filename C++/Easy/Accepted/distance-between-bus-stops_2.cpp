class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int n = distance.size();
        int dist = 0;
        for (int i = start; i != destination; i = (i + 1) % n) {
            dist += distance[i];
        }
        int total = accumulate(distance.begin(), distance.end(), 0);
        return min(dist, total - dist);
    }
};