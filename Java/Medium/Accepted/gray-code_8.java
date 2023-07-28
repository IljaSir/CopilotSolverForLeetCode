class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> code = new ArrayList<>();
        code.add(0);
        if (n == 0) {
            return code;
        }
        code.add(1);
        if (n == 1) {
            return code;
        }
        for (int i = 2; i <= n; i++) {
            int size = code.size();
            for (int j = size - 1; j >= 0; j--) {
                int newNum = code.get(j) + (int) Math.pow(2, i - 1);
                code.add(newNum);
            }
        }
        return code;
    }
}