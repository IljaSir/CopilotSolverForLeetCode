class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int total = 0;
        for (int d : distance) total += d;
        int dist = 0;
        if (start > destination) swap(start, destination);
        for (int i = start; i < destination; i++) dist += distance[i];
        return min(dist, total - dist);
    }
};