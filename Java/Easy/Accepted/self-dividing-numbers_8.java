class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            boolean isSelfDividingNumber = true;
            int temp = i;
            while(temp > 0) {
                int digit = temp % 10;
                if(digit == 0 || i % digit != 0) {
                    isSelfDividingNumber = false;
                    break;
                }
                temp /= 10;
            }
            if(isSelfDividingNumber) result.add(i);
        }
        return result;
    }
}