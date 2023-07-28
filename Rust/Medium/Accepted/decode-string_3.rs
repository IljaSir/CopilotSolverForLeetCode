impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let mut stack: Vec<String> = Vec::new();
        let mut num = 0;
        for c in s.chars() {
            if c.is_digit(10) {
                num = num * 10 + c.to_digit(10).unwrap();
            } else if c == '[' {
                stack.push(num.to_string());
                num = 0;
            } else if c == ']' {
                let mut str = String::new();
                while let Some(v) = stack.pop() {
                    if v.parse::<i32>().is_ok() {
                        let mut temp = String::new();
                        for _ in 0..v.parse::<i32>().unwrap() {
                            temp.push_str(&str);
                        }
                        str = temp;
                        break;
                    } else {
                        str.insert_str(0, &v);
                    }
                }
                stack.push(str);
            } else {
                stack.push(c.to_string());
            }
        }
        stack.join("")
    }
}