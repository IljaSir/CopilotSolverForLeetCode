class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int sum = 0;
        int i = start;
        while (true) {
            sum += distance[i];
            i = (i + 1) % distance.size();
            if (i == destination) {
                break;
            }
        }
        int sum2 = 0;
        i = start;
        while (true) {
            i = (i - 1 + distance.size()) % distance.size();
            sum2 += distance[i];
            if (i == destination) {
                break;
            }
        }
        return min(sum, sum2);
    }
};