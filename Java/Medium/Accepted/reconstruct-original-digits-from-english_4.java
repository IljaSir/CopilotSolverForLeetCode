class Solution {
    public String originalDigits(String s) {
        
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            if (c == 'z') cnt[0]++;
            if (c == 'w') cnt[2]++;
            if (c == 'x') cnt[6]++;
            if (c == 's') cnt[7]++; //7-6
            if (c == 'g') cnt[8]++;
            if (c == 'u') cnt[4]++;
            if (c == 'f') cnt[5]++; //5-4
            if (c == 'h') cnt[3]++; //3-8
            if (c == 'i') cnt[9]++; //9-8-5-6
            if (c == 'o') cnt[1]++; //1-0-2-4
        }
        cnt[7] -= cnt[6];
        cnt[5] -= cnt[4];
        cnt[3] -= cnt[8];
        cnt[9] = cnt[9] - cnt[8] - cnt[5] - cnt[6];
        cnt[1] = cnt[1] - cnt[0] - cnt[2] - cnt[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}