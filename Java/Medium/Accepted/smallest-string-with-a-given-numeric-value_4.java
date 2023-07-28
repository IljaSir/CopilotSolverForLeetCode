class Solution {
    public String getSmallestString(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        k -= n;
        int index = n - 1;
        while (k > 0) {
            int diff = Math.min(25, k);
            char c = sb.charAt(index);
            sb.setCharAt(index, (char) (c + diff));
            k -= diff;
            index--;
        }
        return sb.toString();
    }
}