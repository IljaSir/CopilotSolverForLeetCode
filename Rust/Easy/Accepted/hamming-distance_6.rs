impl Solution {
    pub fn hamming_distance(x: i32, y: i32) -> i32 {
        
        let mut z = x ^ y;
        let mut hamming_distance = 0;
        while z > 0 {
            hamming_distance += z & 1;
            z >>= 1;
        }
        hamming_distance
    }
}