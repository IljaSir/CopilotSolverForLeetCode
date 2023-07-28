impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum = 0;
        let mut i = 0;
        let mut chars = s.chars();
        while let Some(c) = chars.next() {
            let mut next = chars.clone().next();
            match c {
                'I' => {
                    if next == Some('V') {
                        sum += 4;
                        chars.next();
                    } else if next == Some('X') {
                        sum += 9;
                        chars.next();
                    } else {
                        sum += 1;
                    }
                }
                'V' => {
                    sum += 5;
                }
                'X' => {
                    if next == Some('L') {
                        sum += 40;
                        chars.next();
                    } else if next == Some('C') {
                        sum += 90;
                        chars.next();
                    } else {
                        sum += 10;
                    }
                }
                'L' => {
                    sum += 50;
                }
                'C' => {
                    if next == Some('D') {
                        sum += 400;
                        chars.next();
                    } else if next == Some('M') {
                        sum += 900;
                        chars.next();
                    } else {
                        sum += 100;
                    }
                }
                'D' => {
                    sum += 500;
                }
                'M' => {
                    sum += 1000;
                }
                _ => {}
            }
            i += 1;
        }
        sum
    }
}