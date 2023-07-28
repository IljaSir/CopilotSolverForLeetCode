class Solution {
    public int distributeCandies(int[] candyType) {
        
        Set<Integer> types = new HashSet<>();
        for (int type : candyType) {
            types.add(type);
        }
        int n = candyType.length;
        return Math.min(types.size(), n / 2);
    }
}