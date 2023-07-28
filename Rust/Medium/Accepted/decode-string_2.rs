impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let mut stack = Vec::new();
        let mut result = String::new();
        let mut num = 0;
        for c in s.chars() {
            match c {
                '0'..='9' => {
                    num = num * 10 + (c as u8 - b'0') as usize;
                }
                '[' => {
                    stack.push((num, result));
                    num = 0;
                    result = String::new();
                }
                'a'..='z' => {
                    result.push(c);
                }
                ']' => {
                    let (n, mut prev) = stack.pop().unwrap();
                    for _ in 0..n {
                        prev.push_str(&result);
                    }
                    result = prev;
                }
                _ => panic!("Unexpected char: {}", c),
            }
        }
        result
    }
}