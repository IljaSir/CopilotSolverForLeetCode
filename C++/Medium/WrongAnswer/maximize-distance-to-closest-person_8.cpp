class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int maxDis = 0;
        int count = 0;
        int i = 0;
        while (i < seats.size()) {
            if (seats[i] == 0) {
                count++;
            } else {
                maxDis = max(maxDis, count);
                count = 0;
            }
            i++;
        }
        int left = 0;
        int right = seats.size() - 1;
        while (left < seats.size() && seats[left] == 0) {
            left++;
        }
        while (right >= 0 && seats[right] == 0) {
            right--;
        }
        maxDis = max(maxDis, max(left, (int)seats.size() - 1 - right));
        return (maxDis + 1) / 2;
    }
};