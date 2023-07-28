class Solution {
    public int numberOfWays(String corridor) {
        
        // 1. count number of plants
        int plants = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'P') {
                plants++;
            }
        }
        // 2. check if number of plants is even
        if (plants % 2 == 1) {
            return 0;
        }
        // 3. find the number of ways to divide the corridor
        int ans = 1;
        int plantsPerSection = plants / 2;
        int plantCount = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'P') {
                plantCount++;
            }
            if (plantCount == plantsPerSection) {
                ans = (ans * 2) % 1000000007;
                plantCount = 0;
            }
        }
        return ans;
    }
}