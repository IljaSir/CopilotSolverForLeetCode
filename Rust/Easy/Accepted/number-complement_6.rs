impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut n = num;
        let mut c = 0;
        while n > 0 {
            n = n >> 1;
            c = c << 1;
            c += 1;
        }
        c - num
    }
}