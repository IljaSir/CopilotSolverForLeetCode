class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        
def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        d = {}
        for cpdomain in cpdomains:
            count, domain = cpdomain.split()
            count = int(count)
            subdomains = domain.split('.')
            for i in range(len(subdomains)):
                subdomain = '.'.join(subdomains[i:])
                d[subdomain] = d.get(subdomain, 0) + count
        return [str(v) + ' ' + k for k, v in d.items()]