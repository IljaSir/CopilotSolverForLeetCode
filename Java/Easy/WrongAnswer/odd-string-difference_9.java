class Solution {
    public String oddString(String[] words) {
        
        String odd = "";
        int n = words[0].length();
        int[][] diff = new int[words.length][n-1];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n-1; j++) {
                diff[i][j] = words[i].charAt(j+1) - words[i].charAt(j);
            }
        }
        for (int i = 0; i < diff.length; i++) {
            boolean flag = true;
            for (int j = 0; j < diff.length; j++) {
                if (i != j && !Arrays.equals(diff[i], diff[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                odd = words[i];
                break;
            }
        }
        return odd;
    }
}