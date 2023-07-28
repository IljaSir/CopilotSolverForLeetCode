class Solution {
    public int magicalString(int n) {
        
        if (n < 1) {
            return  < n) {
            for (int i = 0; i < arr[head]; i++) {
                arr[tail] = num;
                if (num == 1 && tail < n) {
                    count++;
                }
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        return count;
    }
}