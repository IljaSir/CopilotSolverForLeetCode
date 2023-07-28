impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let i = c as u8 - b'a' + 1;
            sum += i / 10 + i % 10;
        }
        let mut res = sum;
        for _ in 1..k {
            res = 0;
            while sum > 0 {
                res += sum % 10;
                sum /= 10;
            }
            sum = res;
        }
        res
    }
}