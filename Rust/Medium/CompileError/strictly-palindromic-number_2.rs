impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        for i in 2..n {
            let mut m = n;
            let mut s = String::new();
            while m > 0 {
                s.push(std::char::from_digit((m % i) as u32, i).unwrap());
                m /= i;
            }
            if s != s.chars().rev().collect::<String>() {
                return false;
            }
        }
        true
    }
}