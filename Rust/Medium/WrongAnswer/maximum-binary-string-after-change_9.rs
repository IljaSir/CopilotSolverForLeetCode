impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut count = 0;
        let mut first = 0;
        let mut last = 0;
        let mut zero = false;
        for i in 0..binary.len() {
            let c = binary.chars().nth(i).unwrap();
            if c == '0' {
                zero = true;
            }
            if c == '1' {
                count += 1;
            } else {
                if zero {
                    last += 1;
                } else {
                    first += 1;
                }
            }
        }
        let mut result = String::new();
        for _ in 0..first {
            result.push('1');
        }
        for _ in 0..last {
            result.push('0');
        }
        for _ in 0..(binary.len() - count - last) {
            result.push('1');
        }
        result
    }
}