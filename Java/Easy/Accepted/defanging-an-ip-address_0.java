class Solution {
    public String defangIPaddr(String address) {
        
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                result += address.charAt(i);
            } else {
                result += "[.]";
            }
        }
        return result;
    }
}