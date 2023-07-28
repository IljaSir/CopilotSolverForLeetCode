class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int x: nums) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x: nums) {
            if (freq.get(x) == 0) continue;
            else if (appendfreq.getOrDefault(x, 0) > 0) {
                appendfreq.put(x, appendfreq.get(x) - 1);
                appendfreq.put(x+1, appendfreq.getOrDefault(x+1, 0) + 1);
            }
            else if (freq.getOrDefault(x+1, 0) > 0 && freq.getOrDefault(x+2, 0) > 0) {
                freq.put(x+1, freq.get(x+1) - 1);
                freq.put(x+2, freq.get(x+2) - 1);
                appendfreq.put(x+3, appendfreq.getOrDefault(x+3, 0) + 1);
            }
            else return false;
            freq.put(x, freq.get(x) - 1);
        }
        return true;
    }
}