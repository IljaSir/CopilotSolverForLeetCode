class Solution {
    public int maximumGain(String s, int x, int y) {
        
        char[] chars = s.toCharArray();
        int[] count = new int[2];
        int[] score = new int[2];
        score[0] = x;
        score[1] = y;
        int[] order = new int[2];
        order[0] = x > y ? 0 : 1;
        order[1] = x > y ? 1 : 0;
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'a' || c == 'b') {
                int index = c - 'a';
                if (count[order[index]] > 0) {
                    count[order[index]]--;
                    total += score[index];
                } else {
                    count[index]++;
                }
            } else {
                total += Math.min(count[0], count[1]) * score[0];
                count[0] = count[1] = 0;
            }
        }
        total += Math.min(count[0], count[1]) * score[0];
        return total;
    }
}