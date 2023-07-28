impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut r = 0;
        let mut g = 0;
        let mut b = 0;
        for i in 0..rings.len() {
            if i % 2 == 0 {
                match rings.as_bytes()[i] {
                    b'R' => r += 1,
                    b'G' => g += 1,
                    b'B' => b += 1,
                    _ => (),
                }
            }
        }
        let mut result = 0;
        for i in 0..rings.len() {
            if i % 2 == 1 {
                match rings.as_bytes()[i] {
                    b'0' => {
                        if r > 0 && g > 0 && b > 0 {
                            result += 1;
                        }
                    }
                    b'1' => {
                        if r > 1 && g > 0 && b > 0 {
                            result += 1;
                        }
                    }
                    b'2' => {
                        if r > 0 && g > 1 && b > 0 {
                            result += 1;
                        }
                    }
                    b'3' => {
                        if r > 0 && g > 0 && b > 1 {
                            result += 1;
                        }
                    }
                    b'4' => {
                        if r > 1 && g > 1 && b > 0 {
                            result += 1;
                        }
                    }
                    b'5' => {
                        if r > 1 && g > 0 && b > 1 {
                            result += 1;
                        }
                    }
                    b'6' => {
                        if r > 0 && g > 1 && b > 1 {
                            result += 1;
                        }
                    }
                    b'7' => {
                        if r > 1 && g > 1 && b > 1 {
                            result += 1;
                        }
                    }
                    b'8' => {
                        if r > 2 && g > 1 && b > 0 {
                            result += 1;
                        }
                    }
                    b'9' => {
                        if r > 2 && g > 0 && b > 1 {
                            result += 1;
                        }
                    }
                    _ => (),
                }
            }
        }
        result
    }
}