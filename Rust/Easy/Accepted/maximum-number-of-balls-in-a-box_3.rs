impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in low_limit..=high_limit {
            let mut sum = 0;
            let mut num = i;
            while num > 0 {
                sum += num % 10;
                num /= 10;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        map.values().max().unwrap().clone()
    }
}