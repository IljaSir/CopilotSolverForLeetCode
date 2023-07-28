impl Solution {
    pub fn even_odd_bit(n: i32) -> Vec<i32> {
        
        let mut n = n;
        let mut even = 0;
        let mut odd = 0;
        for i in 0..=10 {
            if n & 1 == 1 {
                if i % 2 == 0 {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
            n >>= 1;
        }
        vec![even, odd]
    }
}