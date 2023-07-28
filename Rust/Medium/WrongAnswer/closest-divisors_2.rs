impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let (a, b) = (num + 1, num + 2);
        let (mut x, mut y) = (1, 1);
        for i in 1..=a {
            if a % i == 0 {
                x = i;
            }
        }
        for i in 1..=b {
            if b % i == 0 {
                y = i;
            }
        }
        let (a, b) = (a / x, a / y);
        let (c, d) = (b - x, a - y);
        if c < d {
            vec![x, b]
        } else {
            vec![y, a]
        }
    }
}