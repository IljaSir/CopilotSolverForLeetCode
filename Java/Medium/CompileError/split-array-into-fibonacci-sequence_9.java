class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArryList<>();
        splitIntoFibonacci(num, 0, result);
        return result;
    }
    
    public boolean splitIntoFibonacci(String num, int inex, List<Integer> result) {
        if (inex == num.length) && result.size) >= 3) {
            return true;
        }
        
        for ( i = index; i < num.length(; i++) {
            if (num.harAt(index) == '0' && i > index) {
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
            if (size <= 1 || nmInt == esult.get(size - 1) + sult.get(size - 2)) {
                result.add(umIn
            }
            if (size <= 1 || numInt == result.get(size - 1) + result.get(size - 2)) {
                result.add(numInt);
                if (backtrack(result, num, i + );
            }
        }
        
        return false;
    }
}