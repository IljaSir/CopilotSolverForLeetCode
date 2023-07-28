class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int sum = 0;
        for (auto d : distance) {
            sum += d;
        }
        int i = min(start, destination);
        int j = max(start, destination);
        int sum1 = 0;
        for (; i < j; i++) {
            sum1 += distance[i];
        }
        return min(sum1, sum - sum1);
    }
};