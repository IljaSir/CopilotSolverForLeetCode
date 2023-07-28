impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        for cpdomain in cpdomains {
            let mut iter = cpdomain.split_ascii_whitespace();
            let count = iter.next().unwrap().parse::<i32>().unwrap();
            let mut domain = iter.next().unwrap().to_string();
            while let Some(index) = domain.find('.') {
                *map.entry(domain.clone()).or_insert(0) += count;
                domain = domain[index+1..].to_string();
            }
            *map.entry(domain).or_insert(0) += count;
        }
        let mut result: Vec<String> = Vec::new();
        for (domain, count) in map {
            result.push(format!("{} {}", count, domain));
        }
        result
    }
}