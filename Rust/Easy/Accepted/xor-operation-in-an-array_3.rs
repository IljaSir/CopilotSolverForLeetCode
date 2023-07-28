impl Solution {
    pub fn xor_operation(n: i32, start: i32) -> i32 {
        
        let mut res = start;
        for i in 1..n {
            res ^= start + 2 * i;
        }
        res
    }
}