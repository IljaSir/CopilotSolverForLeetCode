impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut k = k;
        let mut stack = vec![];
        for c in num.chars() {
            let n = c.to_digit(10).unwrap() as i32;
            while k > 0 && !stack.is_empty() && stack.last().unwrap() > &n {
                stack.pop();
                k -= 1;
            }
            stack.push(n);
        }
        while k > 0 {
            stack.pop();
            k -= 1;
        }
        while let Some(0) = stack.first() {
            stack.remove(0);
        }
        if stack.is_empty() {
            "0".to_string()
        } else {
            stack.into_iter().map(|n| n.to_string()).collect()
        }
    }
}