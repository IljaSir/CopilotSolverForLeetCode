impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut a = (num + 1) as f64;
        let mut b = (num + 2) as f64;
        let mut a_div = 0;
        let mut b_div = 0;
        for i in 1..=(num as f64).sqrt() as i32 {
            if num % i == 0 {
                a_div = i;
            }
        }
        a = a / a_div as f64;
        for i in 1..=(num as f64).sqrt() as i32 {
            if (num + 1) % i == 0 {
                b_div = i;
            }
        }
        b = b / b_div as f64;
        if (a - a_div as f64).abs() < (b - b_div as f64).abs() {
            return vec![a_div, a as i32];
        } else {
            return vec![b_div, b as i32];
        }
    }
}