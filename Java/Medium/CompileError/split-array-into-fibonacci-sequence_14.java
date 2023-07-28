class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArrayList<>();
        backtrack(result, num, 0);
        return result;
    }
    
    public boolean backtrack(List<Integer> result, String num, int index) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }
            long numLong = Long.parseLong(num.substring(index, i + 1));
            if (numLong > Integer.MAX_VALUE) {
                break;
            }
            int numInt = (int) numLong;
            int size = result.size();
            if (size >= 2 && numInt > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || numInt == result.get(size - 1) + result.get(size - 2)) {
                result.add(numInt);
                if (backtrack(result, num, i + 1)) {
                    return true;
                }arAt(start) == '0') {
                break;
            }
        }
        return false;
    }
}