class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if queryIP.count('.') == 3:
            parts = queryIP.split('.')
            if len(parts) == 4 and all(part.isdigit() and 0 <= int(part) < 256 and (part == '0' or part[0] != '0') for part in parts):
                return "IPv4"
        if queryIP.count(':') == 7:
            parts = queryIP.split(':')
            if len(parts) == 8 and all(part.isalnum() and 1 <= len(part) <= 4 and all(c in '0123456789abcdefABCDEF' for c in part) for part in parts):
                return "IPv6"
        return "Neither"