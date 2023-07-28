impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        if num == 0 {
            return "0".to_string();
        }
        let mut num = num;
        let mut negative = false;
        if num < 0 {
            negative = true;
            num = -num;
        }
        let mut ans = String::new();
        while num > 0 {
            ans.push((num % 7 + '0' as i32) as u8 as char);
            num /= 7;
        }
        if negative {
            ans.push('-');
        }
        ans.chars().rev().collect()
    }
}