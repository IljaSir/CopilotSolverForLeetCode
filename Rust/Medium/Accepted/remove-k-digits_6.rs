impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut stack = Vec::new();
        let mut k = k;
        for c in num.chars() {
            let c = c.to_digit(10).unwrap();
            while k > 0 && stack.len() > 0 && stack[stack.len() - 1] > c {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }
        while k > 0 {
            stack.pop();
            k -= 1;
        }
        while stack.len() > 0 && stack[0] == 0 {
            stack.remove(0);
        }
        if stack.len() == 0 {
            return "0".to_string();
        }
        stack.iter().map(|&x| x.to_string()).collect()
    }
}