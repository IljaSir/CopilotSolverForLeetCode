impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut last = n & 1;
        n >>= 1;
        while n > 0 {
            let curr = n & 1;
            if curr == last {
                return false;
            }
            last = curr;
            n >>= 1;
        }
        true
    }
}