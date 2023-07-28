impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut k = k;
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
        let mut ans = String::new();
        let mut i = 0;
        while i < stack.len() && stack[i] == '0' {
            i += 1;
        }
        for j in i..stack.len() {
            ans.push(stack[j]);
        }
        if ans.is_empty() {
            "0".to_string()
        } else {
            ans
        }
    }
}