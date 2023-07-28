impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        let mut n = n;
        let mut base = 2;
        while base < n {
            let mut num = n;
            let mut s = String::new();
            while num > 0 {
                s.push_str(&(num % base).to_string());
                num /= base;
            }
            if !Self::is_palindromic(&s) {
                return false;
            }
            base += 1;
        }
        true
    }
    
    fn is_palindromic(s: &String) -> bool {
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s.chars().nth(i).unwrap() != s.chars().nth(j).unwrap() {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}