class Solution {
    public int countPoints(String rings) {
        
        int count = 0;
        for (char c: "RGB".toCharArray()) {
            int[] countRod = new int[10];
            for (int i = 0; i < rings.length(); i += 2) {
                if (rings.charAt(i) == c) {
                    countRod[rings.charAt(i + 1) - '0']++;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (countRod[i] == 3) {
                    count++;
                }
            }
        }
        return count;
    }
}