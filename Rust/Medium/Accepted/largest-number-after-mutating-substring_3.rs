impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut num = num.chars().collect::<Vec<_>>();
        let mut flag = false;
        for i in 0..num.len() {
            let c = num[i] as usize - '0' as usize;
            if change[c] > c as i32 {
                num[i] = (change[c] + '0' as i32) as u8 as char;
                flag = true;
            } else if flag && change[c] < c as i32 {
                break;
            }
        }
        num.iter().collect()
    }
}