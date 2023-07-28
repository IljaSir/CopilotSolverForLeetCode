impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut a = Self::find_divisors(num+1);
        let mut b = Self::find_divisors(num+2);
        
        if (a[0]-a[1]).abs() < (b[0]-b[1]).abs() {
            a
        } else {
            b
        }
    }
    
    fn find_divisors(num: i32) -> Vec<i32> {
        for i in (1..=num).rev() {
            if num % i == 0 {
                return vec![i, num/i];
            }
        }
        vec![]
    }
}