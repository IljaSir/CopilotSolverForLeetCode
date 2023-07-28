impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut stack: Vec<char> = Vec::new();
        let mut k = k;
        for c in num.chars() {
            while !stack.is_empty() && k > 0 && stack[stack.len() - 1] > c {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }
        while k > 0 {
            stack.pop();
            k -= 1;
        }
        let mut i = 0;
        while i < stack.len() && stack[i] == '0' {
            i += 1;
        }
        if i == stack.len() {
            return "0".to_string();
        }
        stack[i..].iter().collect()
    }
}