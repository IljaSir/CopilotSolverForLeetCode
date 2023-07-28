impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut res = "".to_string();
        let mut stack = vec![];
        let mut i = 0;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if stack.is_empty() {
                stack.push(c);
                i += 1;
                continue;
            }
            let t = stack.last().unwrap();
            if t.is_lowercase() && t.to_uppercase().to_string() == c.to_string() {
                stack.pop();
                i += 1;
                continue;
            }
            if t.is_uppercase() && t.to_lowercase().to_string() == c.to_string() {
                stack.pop();
                i += 1;
                continue;
            }
            stack.push(c);
            i += 1;
        }
        let mut j = 0;
        while j < stack.len() {
            let mut k = j + 1;
            let mut t = stack[j].to_string();
            while k < stack.len() {
                t.push(stack[k]);
                k += 1;
            }
            if t.len() > res.len() {
                res = t;
            }
            j += 1;
        }
        res
    }
}