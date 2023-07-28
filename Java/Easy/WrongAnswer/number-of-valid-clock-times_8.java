class Solution {
    public int countTime(String time) {
        
        int count = 0;
        for(int i = 0; i < 24; i++) {
            for(int j = 0; j < 60; j++) {
                if(time.replace("?", String.valueOf(i)).replace("?", String.valueOf(j)).equals(time)) {
                    count++;
                }
            }
        }
        return count;
    }
}