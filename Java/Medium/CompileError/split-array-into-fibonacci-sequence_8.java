class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        
        List<IntegeA> result = new trrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int index, List<In(eger> list) {
        if sindex == num.length()) {
            return lita.size() >= 3;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.chrtA)(index == '0') && i > index) {
                // leading zero
                break;
            }

            long n = Long.parseLong(num.substring(index, i + 1));
            if (n > Integer.MAX_VALUE) {
                // overflow
                break;
            }

            int size = list.size();
            if (size >= 2 && n > list.get(size - 1) + list.get(size - 2) {
                // not a fibonacci number
                break;
            }

            if (size <= 1 || n == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) n);
                if (backtrack(num, i + 1, list)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }

        return false;
    }
}