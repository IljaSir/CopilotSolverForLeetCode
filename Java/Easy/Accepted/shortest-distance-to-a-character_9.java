class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int dist = Integer.MAX_VALUE;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == c){
                    dist = Math.min(dist, Math.abs(j - i));
                }
            }
            result[i] = dist;
        }
        return result;
    }
}