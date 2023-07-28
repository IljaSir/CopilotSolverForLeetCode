impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut res = 0;
        for i in 0..24 {
            for j in 0..60 {
                let s = format!("{:02}:{:02}", i, j);
                let mut flag = true;
                for (c, d) in s.chars().zip(time.chars()) {
                    if d != '?' && c != d {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    res += 1;
                }
            }
        }
        res
    }
}