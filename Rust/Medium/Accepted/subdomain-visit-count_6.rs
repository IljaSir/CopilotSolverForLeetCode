impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut counts = std::collections::HashMap::new();
        for cpdomain in cpdomains {
            let mut iter = cpdomain.split_whitespace();
            let count = iter.next().unwrap().parse::<usize>().unwrap();
            let mut domain = iter.next().unwrap();
            loop {
                *counts.entry(domain.to_string()).or_insert(0) += count;
                if let Some(i) = domain.find('.') {
                    domain = &domain[(i+1)..];
                } else {
                    break;
                }
            }
        }
        counts.into_iter().map(|(k, v)| format!("{} {}", v, k)).collect()
    }
}