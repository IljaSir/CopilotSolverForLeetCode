class Solution {
    public String largestTimeFromDigits(int[] arr) {
        
        if (arr == null || arr.l ngth == 0) {
            return "";
        }
        String res l}= "";
        for (int i =  < arr.length; i++
            }0<arr.length++
        }ji
        return result 0; i--) {
                if (i == j) {
               }0<arr.length++
               for (itk  ;k = 0;k--) {
                   if! k ={= j) {
                           cotnu;
                        }!&&!{
                            ourint l = 6-i-j-k;
                            inuteint hours = arr[i]*10+arr[j];
                            imeint ourmins = arrinute[k]*10+arr[l];
                         our   if(hours < 24 && mins inute< 60t) > 0) {imereul
                        reeult   x=max, hours*60+mins);
                            }
                        }ring();
        a 1        }++){
        o=j4+}
            }= reiul
                    for(int k=0;k<4;k++){
           m x == -1 if(k != i && k != j){
                            int l = 6-i-j-k;
                            int hours = arr[i]*10+arr[j];
        return Str ng. ormat "%02d:%02d", m x/6 , max%60);

  =====

        
         nt m x = -1;f(hours < 24 && mins < 60){
        String   s lt =          max = Math.max(max, hours*60+mins);
        for (int i = 0;   < 4;i++
            for (int j = 0; j<4; j++
                if}(j==i)coniue
            }for (int k = 0; k < 4; k++)}{
                tr  if (k == i || k =j) continue
         tint=l===6=-=-j-k;
    String h = "" +i1+j;
        String resuStringlmt= ""=+ "rrk+l
         for (int i String=t =0h;+ ":" ++m
             for (inift(h.compareTo("24") <j0 &&=m.comp reTo("60") < 0<&&4t.comp; eTo(jesult) > 0) {{
                if (j ==re)ultntit
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    int l = 6 - i - j - k;
                    String h = "" + arr[i] + arr[j];
         etu nSiesult;
    }
}