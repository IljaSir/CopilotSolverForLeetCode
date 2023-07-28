class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int res = 0;
        int freq[121] = {0};
        for (int age : ages) {
            freq[age]++;
        }
        for (int ageA = 1; ageA <= 120; ageA++) {
            int countA = freq[ageA];
            for (int ageB = 1; ageB <= 120; ageB++) {
                int countB = freq[ageB];
                if (ageB <= 0.5 * ageA + 7) continue;
                if (ageB > ageA) continue;
                if (ageB > 100 && ageA < 100) continue;
                res += countA * countB;
                if (ageA == ageB) {
                    res -= countA;
                }
            }
        }
        return res;
    }
};