class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int n = s.length();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (lastSeen[idx] != -1 && distance[idx] != i - lastSeen[idx] - 1) {
                return false;
            }
            lastSeen[idx] = i;
        }
        return true;
    }
}