impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut count = 0;
        let mut first = true;
        let mut ans = String::new();
        for c in binary.chars() {
            if c == '0' {
                if first {
                    ans.push('1');
                    first = false;
                } else {
                    ans.push('0');
                }
                count += 1;
            } else {
                ans.push('1');
                if count > 0 {
                    count -= 1;
                }
            }
        }
        for _ in 0..count {
            ans.push('1');
        }
        ans
    }
}