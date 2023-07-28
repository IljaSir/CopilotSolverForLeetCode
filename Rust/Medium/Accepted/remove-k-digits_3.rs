impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut k = k as usize;
        let mut stack: Vec<char> = Vec::new();
        for c in num.chars() {
            while k > 0 && !stack.is_empty() && stack[stack.len() - 1] > c {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }
        while k > 0 {
            stack.pop();
            k -= 1;
        }
        let mut s: String = stack.into_iter().collect();
        while s.starts_with('0') {
            s.remove(0);
        }
        if s.is_empty() {
            return "0".to_string();
        }
        s
    }
}