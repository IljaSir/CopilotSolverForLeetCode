impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut sum = 0;
        for c in s.chars() {
            let n = c as i32 - 'a' as i32 + 1;
            sum += n / 10 + n % 10;
        }
        let mut k = k;
        while k > 1 {
            let mut tmp = 0;
            while sum > 0 {
                tmp += sum % 10;
                sum /= 10;
            }
            sum = tmp;
            k -= 1;
        }
        sum
    }
}