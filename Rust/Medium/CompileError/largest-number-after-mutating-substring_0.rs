impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut num = num.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < num.len() {
            let d = num[i] as i32 - '0' as i32;
            if d < change[d as usize] {
                while i < num.len() && num[i] as i32 - '0' as i32 <= change[num[i] as i32 - '0' as i32 as usize] {
                    num[i] = (change[num[i] as i32 - '0' as i32 as usize] + '0' as i32) as u8 as char;
                    i += 1;
                }
                break;
            }
            i += 1;
        }
        num.iter().collect()
    }
}