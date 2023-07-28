class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        # IPv4
        if "." in queryIP:
            ip = queryIP.split(".")
            if len(ip) != 4:
                return "Neither"
            for i in ip:
                if not i.isdigit():
                    return "Neither"
                if i[0] == "0" and len(i) > 1:
                    return "Neither"
                if int(i) < 0 or int(i) > 255:
                    return "Neither"
            return "IPv4"
        
        # IPv6
        if ":" in queryIP:
            ip = queryIP.split(":")
            if len(ip) != 8:
                return "Neither"
            for i in ip:
                if not i.isalnum():
                    return "Neither"
                if len(i) > 4:
                    return "Neither"
                for j in i:
                    if j.isdigit():
                        continue
                    if j.isalpha():
                        if j.lower() not in "abcdef":
                            return "Neither"
            return "IPv6"
        
        return "Neither"