impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut ans = String::new();
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        for c in order.chars() {
            for _ in 0..count[c as usize - 'a' as usize] {
                ans.push(c);
            }
            count[c as usize - 'a' as usize] = 0;
        }
        for c in 'a'..='z' {
            for _ in 0..count[c as usize - 'a' as usize] {
                ans.push(c);
            }
        }
        ans
    }
}