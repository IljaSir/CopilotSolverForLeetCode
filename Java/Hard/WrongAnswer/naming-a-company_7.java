class Solution {
    public long distinctNames(String[] ideas) {
        
        int n = ideas.length;
        long ans = 0;
        int[] count = new int[26];
        for (String idea : ideas) {
            count[idea.charAt(0) - 'a']++;
        }
        for (String idea : ideas) {
            ans += count[idea.charAt(0) - 'a'] - 1;
        }
        return ans;
    }
}