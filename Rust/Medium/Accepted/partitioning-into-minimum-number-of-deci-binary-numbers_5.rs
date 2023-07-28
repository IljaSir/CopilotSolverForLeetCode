impl Solution {
    pub fn min_partitions(n: String) -> i32 {
        
        let mut max = 0;
        for c in n.chars() {
            let d = c.to_digit(10).unwrap() as i32;
            if d > max {
                max = d;
            }
        }
        max
    }
}