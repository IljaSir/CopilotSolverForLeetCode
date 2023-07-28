impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut digits: Vec<i32> = n.to_string().chars().map(|c| c.to_digit(10).unwrap() as i32).collect();
        let mut i = digits.len() - 1;
        while i > 0 && digits[i-1] >= digits[i] {
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = digits.len() - 1;
        while digits[j] <= digits[i-1] {
            j -= 1;
        }
        digits.swap(i-1, j);
        digits[i..].reverse();
        let mut result = 0;
        for d in digits {
            result = result * 10 + d;
            if result > i32::MAX {
                return -1;
            }
        }
        result
    }
}