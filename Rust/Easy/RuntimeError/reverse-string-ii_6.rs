impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut ans = String::new();
        let mut i = 0;
        let mut k = k as usize;
        let mut chars = s.chars();
        while let Some(c) = chars.next() {
            if i % (2 * k) < k {
                let mut stack = Vec::new();
                let mut j = i;
                while j < i + k && j < s.len() {
                    stack.push(chars.next().unwrap());
                    j += 1;
                }
                while let Some(c) = stack.pop() {
                    ans.push(c);
                }
                i = j;
            } else {
                ans.push(c);
                i += 1;
            }
        }
        ans
    }
}