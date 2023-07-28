class Solution {
public:
    bool isSelfCrossing(vector<int>& distance) {
        
        int n = distance.size();
        for (int i = 3; i < n; i++) {
            // fourth line crosses first line and onward
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3])
                return true;
            // fifth line meets first line and onward
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2])
                return true;
            // sixth line crosses first line and onward
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3] && distance[i - 1] <= distance[i - 3])
                return true;
        }
        return false;
    }
};