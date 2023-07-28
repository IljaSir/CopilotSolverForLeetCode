class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        
def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        #print(cpdomains)
        domain_dict = {}
        for cpdomain in cpdomains:
            #print(cpdomain)
            count, domain = cpdomain.split(' ')
            #print(count, domain)
            domain_dict[domain] = domain_dict.get(domain, 0) + int(count)
            while '.' in domain:
                domain = domain.split('.', 1)[1]
                domain_dict[domain] = domain_dict.get(domain, 0) + int(count)
        #print(domain_dict)
        return [str(domain_dict[domain]) + ' ' + domain for domain in domain_dict]