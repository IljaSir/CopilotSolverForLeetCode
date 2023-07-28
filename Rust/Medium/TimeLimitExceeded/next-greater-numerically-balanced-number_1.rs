impl Solution {
    pub fn next_beautiful_number(n: i32) -> i32 {
        
        let mut n = n + 1;
        while !Solution::is_beautiful(n) {
            n += 1;
        }
        n
    }
    fn is_beautiful(n: i32) -> bool {
        let mut digits = vec![0; 10];
        let mut n = n;
        while n > 0 {
            digits[(n % 10) as usize] += 1;
            n /= 10;
        }
        digits.iter().enumerate().all(|(i, &x)| x == i as i32)
    }
}