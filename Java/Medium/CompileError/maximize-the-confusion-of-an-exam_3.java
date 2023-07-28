class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                a[i] = answerKey.charAt(i) == 'T' ? 1 : 0;
                b[i] = answerKey.charAt(i) == 'F' ? 1 : 0;
            } else {
                a[i] = answerKey.charAt(i) == 'T' ? a[i - 1] + 1 : 0;
                b[i] = answerKey.charAt(i) == 'F' ? b[i - 1] + 1 : 0;
            }
            max = Math.max(max, a[i]);
            max = Math.max(max, b[i]);
        }
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1){
                c[i] = answerKey.charAt(i) == 'T' ? 1 : 0;
                d[i] = answerKey.charAt(i) == 'F' ? 1 : 0;
            } else {
                c[i] = answerKey.charAt(i) == 'T' ? c[i + 1] + 1 : 0;
                d[i] = answerKey.charAt(i) == 'F' ? d[i + 1] + 1 : 0;
            }
            max = Math.max(max, c[i]);
            max = Math.max(max, d[i]);
        }
        for(int i = 0; i < n; i++){
            int t = a[i] + c[i];
            int f = b[i] + d[i];
            int t1 = a[i] + k;
            int f1 = b[i] + k;
            if(t1 >= n || answerKey.charAt(t1) == 'F'){
                max = Math.max(max, t1);
            }
            if(f1 >= n || answerKey.charAt(f1) == 'T'){
                max = Math.max(max, f1);
            }
            if(t >= n || answerKey.charAt(t) == 'F'){
                max = Math.max(max, t);
            }
            if(f >= n || answer
    }
}