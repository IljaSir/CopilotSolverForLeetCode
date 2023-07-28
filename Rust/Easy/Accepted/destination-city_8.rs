impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut hm: std::collections::HashMap<&str, i32> = std::collections::HashMap::new();
        for p in paths.iter() {
            let (a, b) = (p[0].as_str(), p[1].as_str());
            hm.insert(a, hm.get(a).unwrap_or(&0) - 1);
            hm.insert(b, hm.get(b).unwrap_or(&0) + 1);
        }
        for (k, v) in hm.iter() {
            if *v == 1 {
                return k.to_string();
            }
        }
        return "".to_string();
    }
}