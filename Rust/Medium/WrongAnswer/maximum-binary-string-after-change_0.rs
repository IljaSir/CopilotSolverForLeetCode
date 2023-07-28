impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut count = 0;
        let mut count1 = 0;
        for c in binary.chars() {
            if c == '1' {
                count1 += 1;
            } else {
                count += 1;
            }
            if count == 2 {
                count = 1;
                count1 += 1;
            }
        }
        let mut ans = String::new();
        for _ in 0..count1 {
            ans.push('1');
        }
        for _ in 0..count {
            ans.push('0');
        }
        ans
    }
}