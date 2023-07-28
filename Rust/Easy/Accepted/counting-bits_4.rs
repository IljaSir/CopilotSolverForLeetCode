impl Solution {
    pub fn count_bits(n: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in 0..=n {
            result.push(i.count_ones() as i32);
        }
        result
    }
}