impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        for cpdomain in cpdomains {
            let mut iter = cpdomain.split_whitespace();
            let count: i32 = iter.next().unwrap().parse().unwrap();
            let domain: Vec<&str> = iter.next().unwrap().split('.').collect();
            for i in 0..domain.len() {
                let key: String = domain[i..].join(".");
                *map.entry(key).or_insert(0) += count;
            }
        }
        map.into_iter().map(|(k, v)| format!("{} {}", v, k)).collect()
    }
}