impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut a = num + 1;
        let mut b = num + 2;
        let mut i = 1;
        let mut j = 1;
        let mut min = 0;
        while i * i <= a {
            if a % i == 0 {
                j = a / i;
                min = i;
            }
            i += 1;
        }
        let a = vec![min, j];
        i = 1;
        j = 1;
        min = 0;
        while i * i <= b {
            if b % i == 0 {
                j = b / i;
                min = i;
            }
            i += 1;
        }
        let b = vec![min, j];
        if (a[0] - a[1]).abs() <= (b[0] - b[1]).abs() {
            a
        } else {
            b
        }
    }
}