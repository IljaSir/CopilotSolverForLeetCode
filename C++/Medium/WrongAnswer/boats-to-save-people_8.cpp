class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        
        vector<int> count(limit + 1, 0);
        for (int i = 0; i < people.size(); i++) {
            count[people[i]]++;
        }
        int result = 0;
        for (int i = 1, j = limit; i <= j;) {
            if (i == j) {
                result += count[i] / 2;
                if (count[i] % 2) {
                    result++;
                }
                break;
            }
            if (count[i] > 0 && count[j] > 0) {
                if (count[i] <= count[j]) {
                    result += count[i];
                    count[j] -= count[i];
                    count[i] = 0;
                    i++;
                } else {
                    result += count[j];
                    count[i] -= count[j];
                    count[j] = 0;
                    j--;
                }
            } else if (count[i] > 0) {
                i++;
            } else if (count[j] > 0) {
                j--;
            }
        }
        return result;
    }
};