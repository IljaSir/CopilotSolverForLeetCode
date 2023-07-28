class Solution {
    public int minimumBuckets(String hamsters) {
        
        int count = 0;
        int h = 0;
        for (int i = 0; i < hamsters.length(); i++) {
            if (hamsters.charAt(i) == 'H') {
                h++;
                if (i == 0 || hamsters.charAt(i - 1) == '.') {
                    count++;
                }
            }
        }
        if (hamsters.charAt(hamsters.length() - 1) == 'H') {
            count++;
        }
        return count <= h ? count : -1;
    }
}