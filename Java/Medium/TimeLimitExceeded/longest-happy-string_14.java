class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        int[] count = new int[]{a, b, c};
        char[] letters = new char[]{'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        while (true) {
            int max = 0;
            int index = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
            if (max == 0) {
                break;
            }
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == letters[index] && sb.charAt(sb.length() - 2) == letters[index]) {
                for (int i = 0; i < count.length; i++) {
                    if (i != index && count[i] > 0) {
                        count[i]--;
                        sb.append(letters[i]);
                        break;
                    }
                }
            } else {
                count[index]--;
                sb.append(letters[index]);
            }
        }
        return sb.toString();
    }
}