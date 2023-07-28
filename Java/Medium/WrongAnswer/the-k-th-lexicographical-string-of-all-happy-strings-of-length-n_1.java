class Solution {
    public String getHappyString(int n, int k) {
        
        if (n == 1) {
            if (k == 1) return "a";
            if (k == 2) return "b";
            if (k == 3) return "c";
            return "";
        }
        int[] count = new int[3];
        count[0] = count[1] = count[2] = (int) Math.pow(2, n - 1);
        int i = 0;
        while (i < 3) {
            if (k <= count[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) (i + 'a'));
                while (sb.length() < n) {
                    int j = 0;
                    while (j < 3) {
                        if (j != i && j != sb.charAt(sb.length() - 1) - 'a') {
                            if (k > count[j]) {
                                k -= count[j];
                            } else {
                                sb.append((char) (j + 'a'));
                                break;
                            }
                        }
                        j++;
                    }
                }
                return sb.toString();
            } else {
                k -= count[i];
                i++;
            }
        }
        return "";
    }
}