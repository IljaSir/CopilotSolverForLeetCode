class Solution {
public:
    bool isSelfCrossing(vector<int>& distance) {
        
        int n = distance.size();
        if (n < 4) return false;
        int i = 3;
        while (i < n && distance[i] > distance[i - 2]) {
            i++;
        }
        if (i < n) {
            if (distance[i] >= distance[i - 2] - distance[i - 4]) {
                distance[i - 1] -= distance[i - 3];
            }
            i++;
        }
        while (i < n && distance[i] < distance[i - 2]) {
            i++;
        }
        return i < n;
    }
};