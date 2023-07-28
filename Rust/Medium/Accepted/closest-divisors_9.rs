impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let n = num as i64;
        let v1 = Self::find(n + 1);
        let v2 = Self::find(n + 2);
        if v1.0 <= v2.0 {
            vec![v1.1 as i32, v1.2 as i32]
        } else {
            vec![v2.1 as i32, v2.2 as i32]
        }
    }
    fn find(n: i64) -> (i64, i64, i64) {
        let mut i = (n as f64).sqrt() as i64;
        while i > 0 {
            if n % i == 0 {
                return (n / i - i, i, n / i);
            }
            i -= 1;
        }
        unreachable!()
    }
}