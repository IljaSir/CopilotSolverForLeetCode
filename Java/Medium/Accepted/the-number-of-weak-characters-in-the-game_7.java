class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        int max = 0, count = 0;
        for (int[] p : properties) {
            if (p[1] < max) {
                count++;
            }
            max = Math.max(max, p[1]);
        }
        return count;
    }
}