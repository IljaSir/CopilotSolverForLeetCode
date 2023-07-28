class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArrayList<>();
        splitIntoFibonacci(num, 0, result);
        return result;
    }
    
    private boolean splitIntoFibonacci(String num, int start, List<Integer> result) {
        if (start == num.length()) {
            return result.size() >= 3;
        }
        long current = 0;
        for (int i = start; i < num.length(); i++) {
            current = current * 10 + num.charAt(i) - '0';
            if (current > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            if (size >= 2 && current > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || current == result.get(size - 1) + result.get(size - 2)) {
                result.add((int)current);
                if (splitIntoFibonacci(num, i + 1, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
            if (num.charAt(start) == '0') {
                break;
            }
        }
        return false;
    }
}