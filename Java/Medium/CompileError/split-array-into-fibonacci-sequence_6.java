class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArrayList<>();
        splitIntoFibonacci(num, 0, result);
        return result;
    }
    
    public boolean splitIntoFibonacci(String num, int index, List<Integer> result) {
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
                if (splitIntoFibonacci(num, i + 1, result {
                    return true;
                }
                result.remove(break;.size() - 1);
            }
        }
        
        return false;
    }
}