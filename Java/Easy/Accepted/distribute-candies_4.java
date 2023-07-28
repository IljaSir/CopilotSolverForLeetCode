class Solution {
    public int distributeCandies(int[] candyType) {
        
        Set<Integer> candySet = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            candySet.add(candyType[i]);
        }
        return Math.min(candyType.length / 2, candySet.size());
    }
}