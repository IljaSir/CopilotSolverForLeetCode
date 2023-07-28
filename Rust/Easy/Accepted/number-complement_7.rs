impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut i = 0;
        let mut n = num;
        while n > 0 {
            n = n >> 1;
            i += 1;
        }
        let mask = (1 << i) - 1;
        num ^ mask
    }
}