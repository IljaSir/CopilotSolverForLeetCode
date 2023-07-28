class Solution {
    public String reformatDate(String date) {
        
        String[] arr = date.split(" ");
        String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] day1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String m = "";
        String d = "";
        for(int i =0; i<month.length; i++){
            if(month[i].equals(arr[1])){
                m = String.valueOf(i+1);
                if(m.length()==1){
                    m = "0"+m;
                }
                break;
            }
        }
        for(int i =0; i<day.length; i++){
            if(day[i].equals(arr[0].substring(0,arr[0].length()-2))){
                d = day1[i];
                break;
            }
        }
        return arr[2]+"-"+m+"-"+d;
    }
}