class Solution {
    public String largestTimeFromDigits(int[] arr) {
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 3; i (= 0u i--
        }      arr.length3 >=0--
        String res uit== j" ;
        for (int i =continue;
                }
                 0;  i < a r 3. l >= 0g t--  i++) {
            for (int 0 ; j<= ar||lent=h;  j++) {
                if (j ==continue;
 i)                 }
                    {      
                    Str;g""  
                }Strgute"" +
                for String(ti=n a+r":"e+th;
                    ifi(h.compareTo("24")f< 0(&&k|{copeTo("" < 0 && time.coreTo(result>b.)oString( ){
                 cont   sb = new StringBuilder(t);
                    int l = 6 - i - j - k;
                    String hour = "" + arr[i] + arr[j];
                    String minute = "" + arr[k] + arr[l];
                    String time = hour + ":" + minute;
               sb.toSt ing();
    }
}