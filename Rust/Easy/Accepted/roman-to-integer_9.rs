impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum = 0;
        let mut i = 0;
        while i < s.len() {
            match s.get(i..i+2) {
                None => {
                    sum += Self::roman_to_int_single(s.get(i..i+1).unwrap());
                    break;
                },
                Some("IV") => {
                    sum += 4;
                    i += 2;
                },
                Some("IX") => {
                    sum += 9;
                    i += 2;
                },
                Some("XL") => {
                    sum += 40;
                    i += 2;
                },
                Some("XC") => {
                    sum += 90;
                    i += 2;
                },
                Some("CD") => {
                    sum += 400;
                    i += 2;
                },
                Some("CM") => {
                    sum += 900;
                    i += 2;
                },
                Some(_) => {
                    sum += Self::roman_to_int_single(s.get(i..i+1).unwrap());
                    i += 1;
                }
            }
        }
        sum
    }
    fn roman_to_int_single(s: &str) -> i32 {
        match s {
            "I" => 1,
            "V" => 5,
            "X" => 10,
            "L" => 50,
            "C" => 100,
            "D" => 500,
            "M" => 1000,
            _ => 0
        }
    }
}