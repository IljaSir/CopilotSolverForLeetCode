class Solution {
    public String largestMultipleOfThree(int[] digits) {
        
        int[] count = new int[10];
        int sum = 0;
        for (int i : digits) {
            count[i]++;
            sum += i;
        }
        int mod = sum % 3;
        if (mod == 1) {
            if (count[1] > 0) {
                count[1]--;
            } else if (count[4] > 0) {
                count[4]--;
            } else if (count[7] > 0) {
                count[7]--;
            } else {
                if (count[2] >= 2) {
                    count[2] -= 2;
                } else if (count[2] == 1) {
                    if (count[5] > 0) {
                        count[2]--;
                        count[5]--;
                    } else if (count[8] > 0) {
                        count[2]--;
                        count[8]--;
                    } else {
                        count[2] = 0;
                    }
                }
                if (count[5] >= 2) {
                    count[5] -= 2;
                } else if (count[5] == 1) {
                    if (count[8] > 0) {
                        count[5]--;
                        count[8]--;
                    } else {
                        count[5] = 0;
                    }
                }
                if (count[8] >= 2) {
                    count[8] -= 2;
                }
            }
        } else if (mod == 2) {
            if (count[2] > 0) {
                count[2]--;
            } else if (count[5] > 0) {
                count[5]--;
            } else if (count[8] > 0) {
                count[8]--;
            } else {
                if (count[1] >= 2) {
                    count[1] -= 2;
                } else if (count[1] == 1) {
                    if (count[4] > 0) {
                        count[1]--;
                        count[4]--;
                    } else if (count[7] > 0) {
                        count[1]--;
                        count[7]--;
                    } else {
                        count[1] = 0;
                    }
                }
                if (count[4] >= 2) {
                    count[4] -= 2
    }
}