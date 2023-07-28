impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for domain in cpdomains {
            let mut iter = domain.split_whitespace();
            let count = iter.next().unwrap().parse::<i32>().unwrap();
            let domain = iter.next().unwrap();
            let mut iter = domain.split('.');
            let mut subdomain = String::new();
            while let Some(part) = iter.next() {
                if subdomain.is_empty() {
                    subdomain = part.to_string();
                } else {
                    subdomain = format!("{}.{}", part, subdomain);
                }
                *map.entry(subdomain.clone()).or_insert(0) += count;
            }
        }
        map.into_iter().map(|(k, v)| format!("{} {}", v, k)).collect()
    }
}