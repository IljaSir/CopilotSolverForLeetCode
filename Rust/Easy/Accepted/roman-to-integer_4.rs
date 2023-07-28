impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum = 0;
        let mut i = 0;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            match c {
                'I' => {
                    if i + 1 < s.len() {
                        let next = s.chars().nth(i + 1).unwrap();
                        if next == 'V' {
                            sum += 4;
                            i += 2;
                            continue;
                        } else if next == 'X' {
                            sum += 9;
                            i += 2;
                            continue;
                        }
                    }
                    sum += 1;
                }
                'V' => sum += 5,
                'X' => {
                    if i + 1 < s.len() {
                        let next = s.chars().nth(i + 1).unwrap();
                        if next == 'L' {
                            sum += 40;
                            i += 2;
                            continue;
                        } else if next == 'C' {
                            sum += 90;
                            i += 2;
                            continue;
                        }
                    }
                    sum += 10;
                }
                'L' => sum += 50,
                'C' => {
                    if i + 1 < s.len() {
                        let next = s.chars().nth(i + 1).unwrap();
                        if next == 'D' {
                            sum += 400;
                            i += 2;
                            continue;
                        } else if next == 'M' {
                            sum += 900;
                            i += 2;
                            continue;
                        }
                    }
                    sum += 100;
                }
                'D' => sum += 500,
                'M' => sum += 1000,
                _ => {}
            }
            i += 1;
        }
        sum
    }
}