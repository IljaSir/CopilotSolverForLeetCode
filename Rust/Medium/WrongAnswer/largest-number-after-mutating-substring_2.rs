impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut num = num.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < num.len() {
            let c = num[i] as usize - '0' as usize;
            if change[c] > c as i32 {
                while i < num.len() && num[i] as usize - '0' as usize <= change[c] as usize {
                    num[i] = (change[c] + '0' as i32) as u8 as char;
                    i += 1;
                }
                break;
            }
            i += 1;
        }
        num.iter().collect::<String>()
    }
}