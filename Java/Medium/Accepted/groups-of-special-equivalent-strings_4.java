class Solution {
    public int numSpecialEquivGroups(String[] words) {
        
        Set<String> set = new HashSet<>();
        for (String w : words) {
            int[] a = new int[52];
            for (int i = 0; i < w.length(); i++) {
                a[w.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(a));
        }
        return set.size();
    }
}