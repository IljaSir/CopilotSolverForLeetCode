class Solution {
    public String originalDigits(String s) {
        
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'z': cnt[0]++; break;
                case 'w': cnt[2]++; break;
                case 'u': cnt[4]++; break;
                case 'f': cnt[5]++; break;
                case 'x': cnt[6]++; break;
                case 's': cnt[7]++; break;
                case 'g': cnt[8]++; break;
                case 'h': cnt[3]++; break;
                case 'i': cnt[9]++; break;
                case 'o': cnt[1]++; break;
            }
        }
        cnt[3] -= cnt[8];
        cnt[5] -= cnt[4];
        cnt[7] -= cnt[6];
        cnt[9] -= cnt[5] + cnt[6] + cnt[8];
        cnt[1] -= cnt[0] + cnt[2] + cnt[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (cnt[i]-- > 0) sb.append(i);
        }
        return sb.toString();
    }
}