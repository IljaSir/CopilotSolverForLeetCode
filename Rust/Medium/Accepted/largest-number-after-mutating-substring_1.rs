impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut num = num.as_bytes().to_vec();
        let mut i = 0;
        while i < num.len() {
            if num[i] - b'0' < change[num[i] as usize - b'0' as usize] as u8 {
                num[i] = change[num[i] as usize - b'0' as usize] as u8 + b'0';
                i += 1;
                while i < num.len() && num[i] - b'0' <= change[num[i] as usize - b'0' as usize] as u8 {
                    num[i] = change[num[i] as usize - b'0' as usize] as u8 + b'0';
                    i += 1;
                }
                break;
            }
            i += 1;
        }
        String::from_utf8(num).unwrap()
    }
}