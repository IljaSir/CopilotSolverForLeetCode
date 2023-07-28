class Solution {
    public int numFriendRequests(int[] ages) {
        
        int[] count = new int[121];
        for(int age: ages) {
            count[age]++;
        }
        int res = 0;
        for(int i=1; i<=120; i++) {
            for(int j=1; j<=120; j++) {
                if(i*j >= 100 && i*j < 100 + i) {
                    continue;
                }
                if(i < j) {
                    continue;
                }
                if(i < 0.5*j + 7) {
                    continue;
                }
                if(i == j) {
                    res += count[i]*(count[i]-1);
                } else {
                    res += count[i]*count[j];
                }
            }
        }
        return res;
    }
}