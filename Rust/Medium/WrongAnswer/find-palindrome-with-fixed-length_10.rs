impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut result: Vec<i64> = Vec::new();
        for each in queries {
            let mut tmp = each;
            let mut tmp_str = String::new();
            let mut tmp_str_rev = String::new();
            let mut tmp_result: i64 = 0;
            let mut tmp_result_rev: i64 = 0;
            let mut count = 0;
            let mut is_palindrome = false;
            while count < int_length {
                tmp_str.push_str(&(tmp % 10).to_string());
                tmp /= 10;
                count += 1;
            }
            tmp_str_rev = tmp_str.chars().rev().collect();
            tmp_result = tmp_str.parse().unwrap();
            tmp_result_rev = tmp_str_rev.parse().unwrap();
            if tmp_result * tmp_result_rev > 0 {
                if tmp_result == tmp_result_rev {
                    is_palindrome = true;
                }
            }
            if is_palindrome {
                result.push(tmp_result);
            } else {
                result.push(-1);
            }
        }
        result
    }
}