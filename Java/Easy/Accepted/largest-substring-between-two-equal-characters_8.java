class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] a = new int[26];
        Arrays.fill(a, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (a[j] < 0) {
                a[j] = i;
            } else {
                max = Math.max(max, i - a[j] - 1);
            }
        }
        return max;
    }
}