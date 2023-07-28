impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut count = [0; 128];
        for c in s.as_bytes() {
            count[*c as usize] += 1;
        }
        let mut ans = 0;
        for c in count.iter() {
            ans += c / 2 * 2;
            if ans % 2 == 0 && *c % 2 == 1 {
                ans += 1;
            }
        }
        ans
    }
}