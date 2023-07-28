class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int count = 0;
        HashSet<Character> jewelsSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelsSet.add(jewel);
        }
        for (char stone : stones.toCharArray()) {
            if (jewelsSet.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}