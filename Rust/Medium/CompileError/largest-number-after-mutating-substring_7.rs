impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut result = String::new();
        let num = num.as_bytes();
        let mut i = 0;
        let mut changed = false;
        while i < num.len() {
            let digit = num[i] - b'0';
            if change[digit as usize] > digit {
                result.push((change[digit as usize] + b'0') as char);
                changed = true;
            } else if change[digit as usize] < digit && changed {
                break;
            } else {
                result.push((digit + b'0') as char);
            }
            i += 1;
        }
        if i < num.len() {
            result.push_str(&String::from_utf8(num[i..].to_vec()).unwrap());
        }
        result
    }
}