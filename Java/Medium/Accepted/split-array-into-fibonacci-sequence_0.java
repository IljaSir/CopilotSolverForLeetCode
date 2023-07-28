class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<Integer> result = new ArrayList<>();
        backtrack(result, num, 0);
        return result;
    }

    private boolean backtrack(List<Integer> result, String num, int index) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (curr > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            if (size >= 2 && curr > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || curr == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) curr);
                if (backtrack(result, num, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}