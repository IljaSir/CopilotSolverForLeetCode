class Solution {
    public String oddString(String[] words) {
        
        int n = words[0].length();
        int[] diff = new int[n-1];
        for (int i = 1; i < n; i++) {
            diff[i-1] = words[0].charAt(i) - words[0].charAt(i-1);
        }
        for (int i = 1; i < words.length; i++) {
            boolean odd = false;
            for (int j = 1; j < n; j++) {
                if (words[i].charAt(j) - words[i].charAt(j-1) != diff[j-1]) {
                    odd = true;
                    break;
                }
            }
            if (!odd) return words[i];
        }
        return "";
    }
}