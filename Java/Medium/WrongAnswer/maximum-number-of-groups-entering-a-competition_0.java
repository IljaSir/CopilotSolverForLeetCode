class Solution {
    public int maximumGroups(int[] grades) {
        
        int n = grades.length;
        int[] cnt = new int[100001];
        for (int i = 0; i < n; i++) {
            cnt[grades[i]]++;
        }
        int ans = 0;
        int sum = 0;
        int cntSum = 0;
        for (int i = 100000; i >= 1; i--) {
            if (cnt[i] == 0) {
                continue;
            }
            int num = cnt[i];
            int k = num / (sum + 1);
            ans += k;
            num -= k * (sum + 1);
            cntSum += k * (sum + 1);
            sum += k * (sum + 1);
            if (num > 0) {
                ans++;
                cntSum += num;
                sum += num;
            }
        }
        return ans;
    }
}