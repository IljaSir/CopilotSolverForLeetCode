class Solution {
    public int nextBeautifulNumber(int n) {
        
        String s = String.valueOf(n);
        int[] count = new int[10];
        for(char c : s.toCharArray()) {
            count[c-'0']++;
        }
        int i = 0;
        int j = 0;
        for(i = s.length()-1; i >= 0; i--) {
            count[s.charAt(i)-'0']--;
            j = s.charAt(i)-'0';
            for(j++; j < 10; j++) {
                if(count[j] < j) {
                    break;
                }
            }
            if(j < 10) {
                break;
            }
        }
        if(i < 0) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < i; k++) {
            sb.append(s.charAt(k));
        }
        sb.append(j);
        count[j]++;
        for(j = 0; j < 10; j++) {
            while(count[j] < j) {
                sb.append(j);
                count[j]++;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}