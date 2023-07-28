class Solution {
    public String getHappyString(int n, int k) {
        
        List<String> happyStrings = new ArrayList<>();
        char[] letters = new char[] {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        dfs(n, k, 0, letters, sb, happyStrings);
        return happyStrings.size() < k ? "" : happyStrings.get(k - 1);
    }
    
    private void dfs(int n, int k, int idx, char[] letters, StringBuilder sb, List<String> happyStrings) {
        if (sb.length() == n) {
            happyStrings.add(sb.toString());
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == letters[i]) {
                continue;
            }
            sb.append(letters[i]);
            dfs(n, k, idx + 1, letters, sb, happyStrings);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}