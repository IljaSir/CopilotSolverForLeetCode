class Solution {
    public int numFriendRequests(int[] ages) {
        
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int res = 0;
        for (int i = 15; i <= 120; i++) {
            int c = count[i];
            if (c == 0) {
                continue;
            }
            int min = i / 2 + 7;
            for (int j = min + 1; j <= i; j++) {
                res += count[j];
            }
            res += c * (c - 1);
        }
        return res;
    }
}