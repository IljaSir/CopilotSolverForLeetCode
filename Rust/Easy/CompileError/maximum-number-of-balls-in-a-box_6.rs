impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut map: HashMap<i32, i32> = HashMap::new();
        for i in low_limit..=high_limit {
            let mut sum = 0;
            let mut j = i;
            while j > 0 {
                sum += j % 10;
                j /= 10;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        map.values().max().unwrap().clone()
    }
}