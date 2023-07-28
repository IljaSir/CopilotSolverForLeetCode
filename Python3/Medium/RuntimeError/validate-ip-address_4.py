class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if "." in queryIP:
            return self.validateIPv4(queryIP)
        elif ":" in queryIP:
            return self.validateIPv6(queryIP)
        else:
            return "Neither"