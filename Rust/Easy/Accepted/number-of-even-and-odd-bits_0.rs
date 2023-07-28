impl Solution {
    pub fn even_odd_bit(n: i32) -> Vec<i32> {
        
        let mut n = n;
        let mut even = 0;
        let mut odd = 0;
        let mut i = 0;
        while n > 0 {
            if n & 1 == 1 {
                if i & 1 == 0 {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
            n >>= 1;
            i += 1;
        }
        vec![even, odd]
    }
}