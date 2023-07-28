class Solution {
    public int nextGreaterElement(int n) {
        
        char[] num = Integer.toString(n).toCharArray();
        int i = num.length - 2;
        while (i >= 0 && num[i + 1] <= num[i]) {
            i--;
        }
        if (i >= 0) {
            int j = num.length - 1;
            while (j >= 0 && num[j] <= num[i]) {
                j--;
            }
            swap(num, i, j);
        }
        reverse(num, i + 1);
        try {
            re+;
            j--;
        }
    }
}