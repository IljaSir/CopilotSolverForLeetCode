class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] counts = new int[100001];
        for (int grade : grades) {
            counts[grade]++;
        }
        int[] sums = new int[100001];
        for (int i = 1; i < 100001; i++) {
            sums[i] = sums[i - 1] + counts[i];
        }
        int[] groups = new int[100001];
        groups[0] = 1;
        for (int i = 1; i < 100001; i++) {
            if (counts[i] == 0) {
                groups[i] = groups[i - 1];
            } else {
                int maxGroups = 0;
                for (int j = 1; j * i <= 100000; j++) {
                    int sum = sums[j * i] - sums[i - 1];
                    if (sum >= j) {
                        maxGroups = Math.max(maxGroups, groups[j * i - 1] + 1);
                    }
                }
                groups[i] = maxGroups;
            }
        }
        return groups[100000];
    }
}