impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut cities = Vec::new();
        for p in paths {
            if let Some(idx) = cities.iter().position(|x| x == &p[0]) {
                cities.remove(idx);
            }
            cities.push(p[1]);
        }
        cities[0].clone()
    }
}