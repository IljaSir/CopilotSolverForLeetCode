impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for cpdomain in cpdomains {
            let mut iter = cpdomain.split_whitespace();
            let count = iter.next().unwrap().parse::<i32>().unwrap();
            let domain = iter.next().unwrap();
            let mut subdomains = domain.split('.').collect::<Vec<_>>();
            while let Some(subdomain) = subdomains.pop() {
                let key = subdomains.join(".");
                let key = if key.is_empty() {
                    subdomain.to_string()
                } else {
                    format!("{}.{}", subdomain, key)
                };
                *map.entry(key).or_insert(0) += count;
            }
        }
        map.into_iter()
            .map(|(key, value)| format!("{} {}", value, key))
            .collect()
    }
}