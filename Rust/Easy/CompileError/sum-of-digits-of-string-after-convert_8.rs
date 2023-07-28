impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let n = c as u8 - 96;
            sum += (n / 10) + (n % 10);
        }
        for _ in 1..k {
            let mut s = 0;
            while sum > 0 {
                s += sum % 10;
                sum /= 10;
            }
            sum = s;
        }
        sum
    }
}