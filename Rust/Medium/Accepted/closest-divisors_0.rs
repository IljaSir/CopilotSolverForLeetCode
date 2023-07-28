impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut a = Self::divisors(num + 1);
        let mut b = Self::divisors(num + 2);
        if (a[0] - a[1]).abs() > (b[0] - b[1]).abs() {
            std::mem::swap(&mut a, &mut b);
        }
        a
    }
    fn divisors(num: i32) -> Vec<i32> {
        let mut i = (num as f64).sqrt() as i32;
        while num % i != 0 {
            i -= 1;
        }
        vec![i, num / i]
    }
}