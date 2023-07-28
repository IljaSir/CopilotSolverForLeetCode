class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        int n = num.length();
        List<Integer> res = new ArrayList<>();
        dfs(num, 0, n, res);
        return res;
    }
    
    private boolean dfs(String num, int index, int n, List<Integer> res) {
        if (index == n) {
            return res.size() >= 3;
        }
        for (int i = index; i < n; i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            long numI = Long.parseLong(num.substring(index, i + 1));
            if (numI > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            if (size >= 2 && numI > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || numI == res.get(size - 1) + res.get(size - 2)) {
                res.add((int)numI);
                if (dfs(num, i + 1, n, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}