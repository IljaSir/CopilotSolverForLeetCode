impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut result = 0;
        let mut i = 0;
        let mut n = num;
        while n > 0 {
            if n & 1 == 0 {
                result += 1 << i;
            }
            n >>= 1;
            i += 1;
        }
        result
    }
}