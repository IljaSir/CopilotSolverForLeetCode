class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        
        int total = accumulate(distance.begin(), distance.end(), 0);
        if (start > destination) {
            swap(start, destination);
        }
        int sum = accumulate(distance.begin() + start, distance.begin() + destination, 0);
        return min(sum, total - sum);
    }
};