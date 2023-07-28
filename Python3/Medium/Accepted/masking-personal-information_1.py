class Solution:
    def maskPII(self, s: str) -> str:
        
        if "@" in s:
            name, domain = s.lower().split("@")
            return name[0] + "*" * 5 + name[-1] + "@" + domain
        else:
            digits = "".join([c for c in s if c.isdigit()])
            local = "***-***-" + digits[-4:]
            if len(digits) == 10:
                return local
            return "+" + "*" * (len(digits) - 10) + "-" + local