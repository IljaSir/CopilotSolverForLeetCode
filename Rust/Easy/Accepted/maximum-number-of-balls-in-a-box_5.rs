impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in low_limit..=high_limit {
            let mut sum = 0;
            let mut n = i;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            let count = map.entry(sum).or_insert(0);
            *count += 1;
            if *count > max {
                max = *count;
            }
        }
        max
    }
}