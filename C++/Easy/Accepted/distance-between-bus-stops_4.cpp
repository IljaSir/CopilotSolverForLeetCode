class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int sum = 0;
        for (int i = 0; i < distance.size(); i++) {
            sum += distance[i];
        }
        int sum1 = 0;
        int i = start;
        while (i != destination) {
            sum1 += distance[i];
            i = (i + 1) % distance.size();
        }
        return min(sum1, sum - sum1);
    }
};