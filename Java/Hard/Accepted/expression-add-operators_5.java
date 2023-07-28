class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", ans);
        return ans;
    }
    
    private void dfs(String num, int target, int index, long prev, long multi, String curr, List<String> ans) {
        if (index == num.length()) {
            if (target == prev) {
                ans.add(curr);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long currNum = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(num, target, i + 1, currNum, currNum, curr + currNum, ans);
            } else {
                dfs(num, target, i + 1, prev + currNum, currNum, curr + "+" + currNum, ans);
                dfs(num, target, i + 1, prev - currNum, -currNum, curr + "-" + currNum, ans);
                dfs(num, target, i + 1, prev - multi + multi * currNum, multi * currNum, curr + "*" + currNum, ans);
            }
        }
    }
}