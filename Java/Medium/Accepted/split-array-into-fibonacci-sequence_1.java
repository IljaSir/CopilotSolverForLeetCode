class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> res = new ArrayList<>();
        backtrack(num, res, 0);
        return res;
    }
    
    private boolean backtrack(String num, List<Integer> res, int index) {
        if (index == num.length() && res.size() >= 3) {
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
            
            int size = res.size();
            if (size >= 2 && cur > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            
            if (size <= 1 || cur == res.get(size - 1) + res.get(size - 2)) {
                res.add((int)cur);
                if (backtrack(num, res, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        
        return false;
    }
}