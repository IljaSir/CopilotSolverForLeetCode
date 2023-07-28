impl Solution {
    pub fn even_odd_bit(n: i32) -> Vec<i32> {
        
        let mut even = 0;
        let mut odd = 0;
        let mut n = n;
        let mut i = 0;
        while n > 0 {
            if i % 2 == 0 {
                if n & 1 == 1 {
                    even += 1;
                }
            } else {
                if n & 1 == 1 {
                    odd += 1;
                }
            }
            n >>= 1;
            i += 1;
        }
        return vec![even, odd];
    }
}