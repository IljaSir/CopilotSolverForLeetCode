impl Solution {
    pub fn hamming_distance(x: i32, y: i32) -> i32 {
        
        let mut xor = x ^ y;
        let mut count = 0;
        while xor > 0 {
            count += xor & 1;
            xor >>= 1;
        }
        count
    }
}