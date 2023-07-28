impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut ans = 0;
        for c in s.chars() {
            ans += (c as i32 - 'a' as i32 + 1) % 10 + (c as i32 - 'a' as i32 + 1) / 10;
        }
        for _ in 1..k {
            let mut tmp = 0;
            while ans > 0 {
                tmp += ans % 10;
                ans /= 10;
            }
            ans = tmp;
        }
        ans
    }
}