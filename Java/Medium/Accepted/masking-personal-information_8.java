class Solution {
    public String maskPII(String s) {
        
        if(s.contains("@")) {
        	String[] split = s.split("@");
        	String name = split[0].toLowerCase();
        	String domain = split[1].toLowerCase();
        	return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        } else {
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < s.length(); i++) {
        		if(Character.isDigit(s.charAt(i))) {
        			sb.append(s.charAt(i));
        		}
        	}
        	int len = sb.length();
        	String local = sb.substring(len - 4, len);
        	if(len == 10) {
        		return "***-***-" + local;
        	} else {
        		String country = sb.substring(0, len - 10);
        		return "+" + new String(new char[country.length()]).replace("\0", "*") + "-***-***-" + local;
        	}
        }
    }
}