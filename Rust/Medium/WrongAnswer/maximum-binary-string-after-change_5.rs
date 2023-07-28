impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut binary = binary;
        let mut zero_count = 0;
        let mut one_count = 0;
        let mut first_one = false;
        for c in binary.chars() {
            if c == '0' {
                if first_one {
                    zero_count += 1;
                }
            } else {
                first_one = true;
                one_count += 1;
            }
        }
        let mut res = String::new();
        for _ in 0..one_count {
            res.push('1');
        }
        if zero_count > 0 {
            res.push('0');
        }
        for _ in 0..zero_count-1 {
            res.push('1');
        }
        res
    }
}