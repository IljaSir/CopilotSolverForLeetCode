class Solution {
    public List<String> braceExpansionII(String expression) {
        
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                int j = i, count = 0;
                for (; j < expression.length(); j++) {
                    if (expression.charAt(j) == '{') count++;
                    if (expression.charAt(j) == '}') count--;
                    if (count == 0) break;
                }
                List<String> list = braceExpansionII(expression.substring(i + 1, j));
                ans = merge(ans, list);
                i = j;
            } else if (c == ',') {
                ans.add("");
            } else {
                for (int j = 0; j < ans.size(); j++) {
                    ans.set(j, ans.get(j) + c);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    private List<String> merge(List<String> list1, List<String> list2) {
        List<String> ans = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                ans.add(s1 + s2);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}