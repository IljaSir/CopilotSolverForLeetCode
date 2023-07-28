impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let mut n = c as i32 - 'a' as i32 + 1;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
        }
        if k == 1 {
            return sum;
        }
        return Self::get_lucky(sum.to_string(), k - 1);
    }
}