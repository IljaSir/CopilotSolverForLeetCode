impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for domain in cpdomains {
            let mut iter = domain.split(' ');
            let count: i32 = iter.next().unwrap().parse().unwrap();
            let domain = iter.next().unwrap();
            let mut iter = domain.split('.');
            while let Some(subdomain) = iter.next() {
                let subdomain = iter.as_str();
                let count = map.entry(subdomain.to_string()).or_insert(0);
                *count += count;
            }
        }
        let mut res = Vec::new();
        for (subdomain, count) in map {
            res.push(format!("{} {}", count, subdomain));
        }
        res
    }
}