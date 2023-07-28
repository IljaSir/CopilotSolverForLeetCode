impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            if n % 2 == 1 {
                count += 1;
            }
            n >>= 1;
        }
        count
    }
}