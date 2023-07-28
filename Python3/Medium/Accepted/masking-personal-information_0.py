class Solution:
    def maskPII(self, s: str) -> str:
        
        if '@' in s:
            local, domain = s.split('@')
            return local[0].lower() + '*****' + local[-1].lower() + '@' + domain.lower()
        else:
            digits = ''.join(filter(str.isdigit, s))
            local = digits[-4:]
            if len(digits) == 10:
                return '***-***-' + local
            else:
                return '+' + '*' * (len(digits) - 10) + '-***-***-' + local