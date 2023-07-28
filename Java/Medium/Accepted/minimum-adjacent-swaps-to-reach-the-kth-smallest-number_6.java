class Solution {
    public int getMinSwaps(String num, int k) {
        
        int n = num.length();
        char[] s = num.toCharArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s[i] - '0';
        }
        while (k-- > 0) {
            nextPermutation(a);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == s[i] - '0') {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (a[i] == s[j] - '0') {
                    while (j > i) {
                        swap(s, j, j - 1);
                        j--;
                        ans++;
                    }
                    break;
                }
            }
        }
        return ans;
    }

    public void nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1, n - 1);
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }
}