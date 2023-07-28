class Solution {
    public String largestMultipleOfThree(int[] digits) {
        
        int[] count = new int[10];
        int sum = 0;
        for (int d : digits) {
            count[d]++;
            sum += d;
        }
        while (sum % 3 != 0) {
            if (sum % 3 == 1) {
                if (count[1] > 0) {
                    count[1]--;
                    sum -= 1;
                } else if (count[4] > 0) {
                    count[4]--;
                    sum -= 4;
                } else if (count[7] > 0) {
                    count[7]--;
                    sum -= 7;
                } else if (count[2] > 1) {
                    count[2] -= 2;
                    sum -= 4;
                } else if (count[5] > 1) {
                    count[5] -= 2;
                    sum -= 10;
                } else if (count[8] > 1) {
                    count[8] -= 2;
                    sum -= 16;
                } else if (count[2] > 0 && count[5] > 0) {
                    count[2]--;
                    count[5]--;
                    sum -= 7;
                } else if (count[2] > 0 && count[8] > 0) {
                    count[2]--;
                    count[8]--;
                    sum -= 10;
                } else if (count[5] > 0 && count[8] > 0) {
                    count[5]--;
                    count[8]--;
                    sum -= 13;
                } else {
                    return "";
                }
            } else {
                if (count[2] > 0) {
                    count[2]--;
                    sum -= 2;
                } else if (count[5] > 0) {
                    count[5]--;
                    sum -= 5;
                } else if (count[8] > 0) {
                    count[8]--;
                    sum -= 8;
                } else if (count[1] > 1) {
                    count[1] -= 2;
                    sum -= 2;
                } else if (count[4] > 1) {
                    count[4] -= 2;
                    sum -= 8;
                } else if (count[7] > 1) {
                    count[7] -=
    }
}