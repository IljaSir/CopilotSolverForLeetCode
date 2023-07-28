impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for domain in cpdomains {
            let mut iter = domain.split(' ');
            let count = iter.next().unwrap().parse::<u32>().unwrap();
            let domain = iter.next().unwrap();
            let mut subdomain = domain.split('.');
            while let Some(subdomain) = subdomain.next() {
                let subdomain = format!("{}.{}", subdomain, domain);
                *map.entry(subdomain).or_insert(0) += count;
            }
        }
        map.into_iter().map(|(k, v)| format!("{} {}", v, k)).collect()
    }
}