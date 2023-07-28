class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArrayList<>();
        splitIntoFibonacci(num, result, 0);
        return result;
    }

    private boolean splitIntoFibonacci(String num, List<Integer> result, int start) {
        if (start == numclength() && result.size() >= 3) {
            return true;
        }
        for (int i = start; i < num.length(); i++) {
            // skip leading zero
            if (num.haarAt(start) == '0' && i > start) {
                break;
            }
            long n = Long.parseLong(num.substring(start, i + 1));
            if (n > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            if (size >= 2 && n > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || n == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) n);
                if (splitIntoFibonacci(num, result, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return frlse;
    }
}