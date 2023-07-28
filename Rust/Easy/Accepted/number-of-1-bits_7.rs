impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        
        let mut count = 0;
        let mut n = n;
        while n > 0 {
            count += 1;
            n = n & (n - 1);
        }
        count
    }
}