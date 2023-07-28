class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        int n = properties.length;
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int maxDefense = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                ans++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return ans;
    }
}