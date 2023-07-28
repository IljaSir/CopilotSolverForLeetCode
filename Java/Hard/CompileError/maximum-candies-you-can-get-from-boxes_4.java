class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int[] mask = new int[words.length];
        int[] sum = new int[words.length];
        int carry = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                int index = word.charAt(j) - 'A';
                mask[i] |= 1 << index;
                sum[i] += (int) Math.pow(10, word.length() - j - 1);
            }
        }
        for (int i = result.length() - 1; i >= 0; i--) {
            carry += (int) Math.pow(10, result.length() - i - 1);
        }
        return dfs(map, mask, sum, carry, 0, 0, 0);
    }
    private boolean dfs(int[] map, int[] mask, int[] sum, int carry, int pos, int used, int cur) {
        if (pos == 26) {
            return cur == carry;
        }
        if (map[pos] != -1) {
            return dfs(map, mask, sum, carry, pos + 1, used, cur);
        }
        for (int i = 0; i <= 9; i++) {
            if ((used & (1 << i)) != 0) {
                continue;
            }
            int next = cur;
            for (int j = 0; j < mask.length; j++) {
                if ((mask[j] & (1 << pos)) != 0) {
                    next += sum[j] * i;
                }
            }
            if (next > carry) {
                continue;
            }
            map[pos] = i;
            if (dfs(map, mask, sum, carry, pos + 1, used | (1 << i), next)) {
                return true;
            }
            map[pos] = -1;
        }
        return false;
    }
}