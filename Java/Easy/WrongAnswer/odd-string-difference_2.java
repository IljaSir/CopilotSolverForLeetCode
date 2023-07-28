class Solution {
    public String oddString(String[] words) {
        
        int n = words[0].length();
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = words[0].charAt(i + 1) - words[0].charAt(i);
        }
        for (int i = 1; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1; j++) {
                if (words[i].charAt(j + 1) - words[i].charAt(j) != diff[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return words[i];
            }
        }
        return "";
    }
}