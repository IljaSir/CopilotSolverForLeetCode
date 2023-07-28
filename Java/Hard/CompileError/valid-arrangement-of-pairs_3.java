class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        for(int i = 0; i < pairs.length; i++) {
            for(int j = i + 1; j < pairs.length; j++) {
                if(pairs[i][1] == pairs[j][0]) {
                    swap(pairs, i + 1, j);
                }
            }
        }
        return pairs;
    }
}