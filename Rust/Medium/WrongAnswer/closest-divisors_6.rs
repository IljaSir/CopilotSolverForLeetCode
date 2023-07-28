impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut n1 = num + 1;
        let mut n2 = num + 2;
        while n1 > 0 {
            let mut n = (n1 as f64).sqrt() as i32;
            while n > 0 {
                if n1 % n == 0 {
                    return vec![n, n1 / n];
                }
                n -= 1;
            }
            n1 -= 1;
        }
        while n2 > 0 {
            let mut n = (n2 as f64).sqrt() as i32;
            while n > 0 {
                if n2 % n == 0 {
                    return vec![n, n2 / n];
                }
                n -= 1;
            }
            n2 -= 1;
        }
        vec![]
    }
}