class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        
def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        d = {}
        for domain in cpdomains:
            n, domain = domain.split()
            n = int(n)
            domain = domain.split('.')
            for i in range(len(domain)):
                subdomain = '.'.join(domain[i:])
                if subdomain not in d:
                    d[subdomain] = n
                else:
                    d[subdomain] += n
        return [str(d[k]) + ' ' + k for k in d]