impl Solution {
    pub fn solve_equation(equation: String) -> String {
        

        let mut left = 0;
        let mut right = 0;
        let mut sign = 1;
        let mut coef = 0;
        let mut num = 0;
        let mut is_left = true;
        for c in equation.chars() {
            match c {
                '0'..='9' => {
                    num = num * 10 + (c as u8 - b'0') as i32;
                }
                'x' => {
                    coef += sign * num * if is_left {1} else {-1};
                    num = 0;
                }
                '+' | '-' => {
                    right += sign * num;
                    num = 0;
                    sign = if c == '+' {1} else {-1};
                }
                '=' => {
                    right += sign * num;
                    num = 0;
                    sign = 1;
                    is_left = false;
                }
                _ => {}
            }
        }
        right += sign * num;
        if coef == 0 {
            if right == 0 {
                "Infinite solutions".to_string()
            } else {
                "No solution".to_string()
            }
        } else {
            format!("x={}", -right / coef)
        }
    }
}