impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let mut flag = false;
        while i < num.len() {
            let c = num.chars().nth(i).unwrap();
            let n = c as i32 - '0' as i32;
            if change[n as usize] > n {
                flag = true;
                res.push((change[n as usize] + '0' as i32) as u8 as char);
            } else if change[n as usize] < n {
                if flag {
                    res.push(c);
                } else {
                    res.push((change[n as usize] + '0' as i32) as u8 as char);
                }
                flag = false;
            } else {
                res.push(c);
            }
            i += 1;
        }
        res
    }
}