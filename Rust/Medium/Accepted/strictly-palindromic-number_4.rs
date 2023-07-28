impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        for i in 2..n-1 {
            let mut x = n;
            let mut s = String::new();
            while x > 0 {
                s.push_str(&(x % i).to_string());
                x /= i;
            }
            let mut j = 0;
            let mut k = s.len() - 1;
            while j < k {
                if s.chars().nth(j).unwrap() != s.chars().nth(k).unwrap() {
                    break;
                }
                j += 1;
                k -= 1;
            }
            if j < k {
                return false;
            }
        }
        true
    }
}