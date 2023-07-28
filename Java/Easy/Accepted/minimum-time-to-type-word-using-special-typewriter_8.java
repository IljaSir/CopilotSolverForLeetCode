class Solution {
    public int minTimeToType(String word) {
        
        int count = 0;
        int curr = 0;
        for(int i = 0; i < word.length(); i++){
            int val = word.charAt(i) - 'a';
            int diff = Math.abs(val - curr);
            count += Math.min(diff, 26 - diff);
            count++;
            curr = val;
        }
        return count;
    }
}