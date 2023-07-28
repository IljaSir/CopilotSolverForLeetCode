impl Solution {
    pub fn min_partitions(n: String) -> i32 {
        
        let mut max = 0;
        for c in n.chars() {
            let cur = c.to_digit(10).unwrap() as i32;
            if cur > max {
                max = cur;
            }
        }
        max
    }
}