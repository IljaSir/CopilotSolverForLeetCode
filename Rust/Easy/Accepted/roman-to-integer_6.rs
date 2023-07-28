impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum: i32 = 0;
        let mut s = s.chars().collect::<Vec<_>>();
        let mut i = 0;
        while i < s.len() {
            match s[i] {
                'M' => sum += 1000,
                'D' => sum += 500,
                'C' => {
                    if i + 1 < s.len() {
                        if s[i + 1] == 'D' {
                            sum += 400;
                            i += 1;
                        } else if s[i + 1] == 'M' {
                            sum += 900;
                            i += 1;
                        } else {
                            sum += 100;
                        }
                    } else {
                        sum += 100;
                    }
                }
                'L' => sum += 50,
                'X' => {
                    if i + 1 < s.len() {
                        if s[i + 1] == 'L' {
                            sum += 40;
                            i += 1;
                        } else if s[i + 1] == 'C' {
                            sum += 90;
                            i += 1;
                        } else {
                            sum += 10;
                        }
                    } else {
                        sum += 10;
                    }
                }
                'V' => sum += 5,
                'I' => {
                    if i + 1 < s.len() {
                        if s[i + 1] == 'V' {
                            sum += 4;
                            i += 1;
                        } else if s[i + 1] == 'X' {
                            sum += 9;
                            i += 1;
                        } else {
                            sum += 1;
                        }
                    } else {
                        sum += 1;
                    }
                }
                _ => {}
            }
            i += 1;
        }
        sum
    }
}