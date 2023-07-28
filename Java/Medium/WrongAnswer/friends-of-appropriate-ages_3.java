class Solution {
    public int numFriendRequests(int[] ages) {
        
        int[] count = new int[121];
        for (int age : ages)
            count[age]++;
        int res = 0;
        for (int i = 1; i <= 120; i++)
            for (int j = 1; j <= 120; j++)
                if (i * 0.5 + 7 < j && i < j && j <= 100 || i < j && j > 100 && i > 100)
                    res += count[i] * (count[j] - (i == j ? 1 : 0));
        return res;
    }
}