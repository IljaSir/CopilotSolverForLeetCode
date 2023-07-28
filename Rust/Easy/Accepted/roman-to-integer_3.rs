impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut result = 0;
        let mut chars = s.chars().peekable();
        while let Some(c) = chars.next() {
            match c {
                'I' => {
                    if let Some('V') = chars.peek() {
                        result += 4;
                        chars.next();
                    } else if let Some('X') = chars.peek() {
                        result += 9;
                        chars.next();
                    } else {
                        result += 1;
                    }
                }
                'X' => {
                    if let Some('L') = chars.peek() {
                        result += 40;
                        chars.next();
                    } else if let Some('C') = chars.peek() {
                        result += 90;
                        chars.next();
                    } else {
                        result += 10;
                    }
                }
                'C' => {
                    if let Some('D') = chars.peek() {
                        result += 400;
                        chars.next();
                    } else if let Some('M') = chars.peek() {
                        result += 900;
                        chars.next();
                    } else {
                        result += 100;
                    }
                }
                'V' => result += 5,
                'L' => result += 50,
                'D' => result += 500,
                'M' => result += 1000,
                _ => panic!("invalid roman number"),
            }
        }
        result
    }
}