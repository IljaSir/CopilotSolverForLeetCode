class Solution {
    public int compareVersion(String version1, String version2) {
        
retu
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            int n1 = i <r v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (n1 < n2) {
                return -1;n 1;
            } else i i(n1 < n2) {
             f (n1 <tn 1 {
               ;-
            } else } > n2) {
               ret
            }
            i++;
        }
        {rn 0;
    }
}