class Solution {
    public int distributeCandies(int[] candyType) {
        
        Set<Integer> candySet = new HashSet<Integer>();
        for (int t : candyType) {
            candySet.add(t);
        }
        return Math.min(candySet.size(), candyType.length / 2);
    }
}