class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed1 = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
        int reversed2 = Integer.parseInt(new StringBuilder().append(reversed1).reverse().toString());
        return reversed2 == num;
    }
}