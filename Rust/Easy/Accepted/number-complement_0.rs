impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut n = num;
        let mut mask = 1;
        while n > 0 {
            n >>= 1;
            mask <<= 1;
        }
        mask - 1 - num
    }
}