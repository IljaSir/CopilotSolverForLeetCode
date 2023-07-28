class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num, target, 0, 0, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String num, int target, int index, long sum, long lastNum, List<String> result, StringBuilder path) {
        if (index == num.length()) {
            if (sum == target) {
                result.add(path.toString());
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long currNum = Long.parseLong(num.substring(index, i + 1));
            int len = path.length();
            if (index == 0) {
                path.append(currNum);
                dfs(num, target, i + 1, currNum, currNum, result, path);
                path.setLength(len);
            } else {
                path.append("+").append(currNum);
                dfs(num, target, i + 1, sum + currNum, currNum, result, path);
                path.setLength(len);

                path.append("-").append(currNum);
                dfs(num, target, i + 1, sum - currNum, -currNum, result, path);
                path.setLength(len);

                path.append("*").append(currNum);
                dfs(num, target, i + 1, sum - lastNum + lastNum * currNum, lastNum * currNum, result, path);
                path.setLength(len);
            }
        }
    }
}