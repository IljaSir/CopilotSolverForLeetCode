impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let (a, b) = (num + 1, num + 2);
        let (mut x, mut y) = (0, 0);
        for i in 1..=(a as f64).sqrt() as i32 {
            if a % i == 0 {
                x = i;
            }
        }
        for i in 1..=(b as f64).sqrt() as i32 {
            if b % i == 0 {
                y = i;
            }
        }
        if (a / x - x).abs() < (b / y - y).abs() {
            vec![x, a / x]
        } else {
            vec![y, b / y]
        }
    }
}