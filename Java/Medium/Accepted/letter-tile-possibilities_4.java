class Solution {
    public int numTilePossibilities(String tiles) {
        
        int[] count = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            count[tiles.charAt(i) - 'A']++;
        }
        return permutations(count);
    }
    
    private int permutations(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            sum++;
            count[i]--;
            sum += permutations(count);
            count[i]++;
        }
        return sum;
    }
}