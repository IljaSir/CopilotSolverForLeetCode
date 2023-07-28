class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int res = 0;
        vector<int> ageCount(121, 0);
        for (int age : ages) {
            ageCount[age]++;
        }
        for (int ageA = 1; ageA <= 120; ageA++) {
            int countA = ageCount[ageA];
            for (int ageB = 1; ageB <= 120; ageB++) {
                int countB = ageCount[ageB];
                if (ageB <= 0.5 * ageA + 7) continue;
                if (ageB > ageA) continue;
                if (ageB > 100 && ageA < 100) continue;
                res += countA * countB;
                if (ageA == ageB) res -= countA;
            }
        }
        return res;
    }
};