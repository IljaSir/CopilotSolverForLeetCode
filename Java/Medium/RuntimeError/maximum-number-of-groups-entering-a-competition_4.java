class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] counts = new int[100001];
        for (int grade : grades) {
            counts[grade]++;
        }
        int ans = 0;
        for (int i = 1; i < counts.length; i++) {
            ans += counts[i] / i;
            counts[i + 1] += counts[i] % i;
        }
        return ans;
    }
}