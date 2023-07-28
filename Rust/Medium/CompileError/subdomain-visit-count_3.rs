impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for cpdomain in cpdomains {
            let vec: Vec<&str> = cpdomain.split(' ').collect();
            let count = vec[0].parse::<i32>().unwrap();
            let mut domain = vec[1].to_string();
            let mut vec: Vec<&str> = domain.split('.').collect();
            while let Some(d) = vec.pop() {
                domain = d.to_string() + "." + &domain;
                let c = map.entry(domain.clone()).or_insert(0);
                *c += count;
            }
        }
        let mut res = Vec::new();
        for (k, v) in map {
            res.push(v.to_string() + " " + &k[..k.len() - 1]);
        }
        res
    }
}