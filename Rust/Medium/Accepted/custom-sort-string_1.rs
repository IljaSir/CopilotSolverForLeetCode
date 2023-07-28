impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut count = [0; 26];
        for c in s.chars() {
            count[(c as u8 - b'a') as usize] += 1;
        }
        let mut ret = String::new();
        for c in order.chars() {
            let idx = (c as u8 - b'a') as usize;
            while count[idx] > 0 {
                ret.push(c);
                count[idx] -= 1;
            }
        }
        for c in 'a' as u8..='z' as u8 {
            let idx = (c - b'a') as usize;
            while count[idx] > 0 {
                ret.push(c as char);
                count[idx] -= 1;
            }
        }
        ret
    }
}