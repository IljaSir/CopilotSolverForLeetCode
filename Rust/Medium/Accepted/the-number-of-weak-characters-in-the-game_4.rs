impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_unstable_by(|a, b| b[0].cmp(&a[0]).then(a[1].cmp(&b[1])));
        let mut max_defense = 0;
        let mut count = 0;
        for p in properties {
            if p[1] < max_defense {
                count += 1;
            }
            max_defense = max_defense.max(p[1]);
        }
        count
    }
}