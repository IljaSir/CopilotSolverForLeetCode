class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] count = new int[100001];
        for (int grade : grades) {
            count[grade]++;
        }
        int ans = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                ans++;
                count[i]--;
                int sum = i;
                int j = i + 1;
                while (j < count.length && count[j] > 0) {
                    if (sum + j <= i * 2) {
                        sum += j;
                        count[j]--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}