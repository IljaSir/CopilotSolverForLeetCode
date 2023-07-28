impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let mut stack = vec![];
        let mut result = String::new();
        let mut number = 0;
        for c in s.chars() {
            match c {
                '0'..='9' => number = number * 10 + c as i32 - '0' as i32,
                '[' => {
                    stack.push(result);
                    stack.push(number.to_string());
                    result = String::new();
                    number = 0;
                },
                ']' => {
                    let mut temp = String::new();
                    let mut count = stack.pop().unwrap().parse::<i32>().unwrap();
                    while count > 0 {
                        temp.push_str(&result);
                        count -= 1;
                    }
                    result = stack.pop().unwrap() + &temp;
                },
                _ => result.push(c),
            }
        }
        result
    }
}