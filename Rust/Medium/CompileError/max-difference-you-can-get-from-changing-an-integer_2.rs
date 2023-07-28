impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut num_str = num.to_string();
        let mut max_str = num_str.clone();
        let mut min_str = num_str.clone();
        let mut max_num = 0;
        let mut min_num = 0;
        let mut max_digit = 0;
        let mut min_digit = 0;
        let mut max_digit_count = 0;
        let mut min_digit_count = 0;
        let mut max_digit_index = 0;
        let mut min_digit_index = 0;
        for (i, c) in num_str.chars().enumerate() {
            if c.to_digit(10).unwrap() > max_digit {
                max_digit = c.to_digit(10).unwrap();
                max_digit_index = i;
                max_digit_count = 1;
            } else if c.to_digit(10).unwrap() == max_digit {
                max_digit_count += 1;
            }
            if c.to_digit(10).unwrap() < min_digit {
                min_digit = c.to_digit(10).unwrap();
                min_digit_index = i;
                min_digit_count = 1;
            } else if c.to_digit(10).unwrap() == min_digit {
                min_digit_count += 1;
            }
        }
        if max_digit != 9 {
            for (i, c) in max_str.chars_mut().enumerate() {
                if c.to_digit(10).unwrap() == max_digit {
                    c = '9';
                    if i == max_digit_index && max_digit_count == 1 {
                        break;
                    }
                }
            }
        }
        if min_digit != 1 {
            for (i, c) in min_str.chars_mut().enumerate() {
                if c.to_digit(10).unwrap() == min_digit {
                    c = '1';
                    if i == min_digit_index && min_digit_count == 1 {
                        break;
                    }
                }
            }
        }
        max_num = max_str.parse().unwrap();
        min_num = min_str.parse().unwrap();
        max_num - min_num
    }
}