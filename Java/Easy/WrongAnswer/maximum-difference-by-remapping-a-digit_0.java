class Solution {
    public int minMaxDifference(int num) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String s = String.valueOf(num);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String t = s.replace(String.valueOf(i), String.valueOf(j));
                if (t.length() > 1 && t.charAt(0) == '0') {
                    continue;
                }
                int n = Integer.parseInt(t);
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
        }
        return max - min;
    }
}