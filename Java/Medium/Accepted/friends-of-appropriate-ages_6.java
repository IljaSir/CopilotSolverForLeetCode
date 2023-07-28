class Solution {
    public int numFriendRequests(int[] ages) {
        
        int[] ageCount = new int[121];
        for (int age : ages) {
            ageCount[age]++;
        }
        int res = 0;
        for (int ageA = 15; ageA <= 120; ageA++) {
            int countA = ageCount[ageA];
            for (int ageB = 15; ageB <= 120; ageB++) {
                int countB = ageCount[ageB];
                if (ageA * 0.5 + 7 >= ageB) {
                    continue;
                }
                if (ageA < ageB) {
                    continue;
                }
                if (ageA < 100 && ageB > 100) {
                    continue;
                }
                res += countA * countB;
                if (ageA == ageB) {
                    res -= countA;
                }
            }
        }
        return res;
    }
}