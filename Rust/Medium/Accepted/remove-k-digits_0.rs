impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut stack = Vec::new();
        let mut k = k;
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
        let mut flag = false;
        for c in stack {
            if c == '0' && !flag {
                continue;
            }
            flag = true;
            ans.push(c);
        }
        if ans.is_empty() {
            return "0".to_string();
        }
        ans
    }
}