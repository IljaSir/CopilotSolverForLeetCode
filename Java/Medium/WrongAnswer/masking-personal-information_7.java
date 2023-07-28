class Solution {
    public String maskPII(String s) {
        
        if(s.contains("@")){
            return maskEmail(s);
        }
        return maskPhone(s);
    }
    private String maskEmail(String s){
        String[] arr = s.split("@");
        String name = arr[0].toLowerCase();
        String domain = arr[1].toLowerCase();
        return name.charAt(0)+"*****"+name.charAt(name.length()-1)+"@"+domain;
    }
    private String maskPhone(String s){
        String local = s.replaceAll("[^0-9]", "");
        String countryCode = "";
        if(local.length() > 10){
            countryCode = "+" + local.substring(0, local.length()-10) + "-";
        }
        return countryCode + "***-***-" + local.substring(local.length()-4);
    }
}