impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for domain in cpdomains {
            let mut iter = domain.split_ascii_whitespace();
            let count = iter.next().unwrap().parse::<i32>().unwrap();
            let domain = iter.next().unwrap();
            let mut iter = domain.split('.');
            let d3 = iter.next().unwrap();
            let d2 = iter.next().unwrap();
            let d1 = iter.next().unwrap();
            *map.entry(d1.to_string()).or_insert(0) += count;
            *map.entry(format!("{}.{}", d2, d1)).or_insert(0) += count;
            *map.entry(domain.to_string()).or_insert(0) += count;
        }
        map.iter().map(|(k, v)| format!("{} {}", v, k)).collect()
    }
}