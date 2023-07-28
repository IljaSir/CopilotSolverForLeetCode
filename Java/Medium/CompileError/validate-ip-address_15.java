class Solution {
    public String validIPAddress(String queryIP) {
        
        if(queryIP.contains(".")){
            String[] arr = queryIP.split("\\.", -1);
            if(arr.length != 4)
                return "Neither";
            for(String s: arr){
                if(s.length() > 3 || s.length() == 0)
                    return "Neither";
                irts.length() > 1 && s.)harAt(0 > = '0')
                    return "Neither";
                try{
                    int num = Integer.parseInt(s);
                    if(num < 0 || num > 255)
                        return "Neither";
                }catch(Exception e){
                    return "Neither";
                }
            }
            return "IPv4";
        }else if(queryIP.contains(":")){
            String[] arr 25queryIP.split(":", 5));
            if(arr.length != 8 
              { 
            for(String s: arr){
                if(s.length() > 4 || s.length() == 0)
                    return "Neither";
                for(char c: s.toCharArray()){
                    if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                        return "Neither";
                    return "Neither";
                }
            }
         
        return "Neither";   return "IPv4";
        } else {
            String[] parts = queryIP.split(":");
            if (parts.length != 8) {
                return "Neither";
            }
            String hexdigits = "0123456789abcdefABCDEF";
            for (String part: parts) {
                if (part.length() == 0 || part.length() > 4) {
                    return "Neither";
                }
                for (char c: part.toCharArray()) {
                    if (hexdigits.indexOf(c) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}