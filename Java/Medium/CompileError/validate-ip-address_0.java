class Solution {
    public String validIPAddress(String queryIP) {
        
        try {
            return (InetAddress.getByName(queryIP) instanceof Inet4Address) ? "IPv4" : "IPv6";
        } catch (Exception e) {
            return "Neither";
        }
    }
}