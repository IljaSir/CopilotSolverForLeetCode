class Solution {
    public String getHappyString(int n, int k) {
        
        int[] count = new int[3];
        Arrays.fill(count, n);
        int total = 3 * (int)Math.pow(2, n - 1);
        if (k > total) {
            return "";
        }
        int[] pos = new int[3];
        Arrays.fill(pos, 1);
        while (true) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (pos[i] == 1 && count[i] < min) {
                    min = count[i];
                    index = i;
                }
            }
            if (k <= total / 3) {
                return getString(index, n);
            }
            k -= total / 3;
            total /= 3;
            count[index]--;
            pos[index] = 0;
            for (int i = 0; i < 3; i++) {
                if (i != index) {
                    pos[i] = 1;
                }
            }
        }
    }

    private String getString(int index, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)('a' + index));
        while (sb.length() < n) {
            sb.append((char)('a' + 3 - index - sb.charAt(sb.length() - 1) + 'a'));
        }
        return sb.toString();
    }
}