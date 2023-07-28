class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        int ans = 0;
        Arrays.sort(properties, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < max) {
                ans++;
            } else {
                max = properties[i][1];
            }
        }
        return ans;
    }
}