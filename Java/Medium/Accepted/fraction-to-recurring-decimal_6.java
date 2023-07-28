class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        ans.append(num / den);
        num %= den;
        if (num == 0) {
            return ans.toString();
        }
        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, ans.length());
        while (num != 0) {
            num *= 10;
            ans.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                ans.insert(index, "(");
                ans.append(")");
                break;
            } else {
                map.put(num, ans.length());
            }
        }
        return ans.toString();
    }
}