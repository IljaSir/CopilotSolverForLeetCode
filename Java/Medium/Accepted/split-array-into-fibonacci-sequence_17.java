class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, num, 0);
        return ans;
    }

    public boolean backtrack(List<Integer> ans, String num, int index) {
        if (index == num.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (cur > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            if (size >= 2 && cur > ans.get(size - 1) + ans.get(size - 2)) {
                break;
            }
            if (size <= 1 || cur == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) cur);
                if (backtrack(ans, num, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}