class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        if (s.equals(goal)) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 1) {
                    return true;
                }
            }
            return false;
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}