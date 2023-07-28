impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        for i in 0..24 {
            for j in 0..60 {
                let s = format!("{:02}:{:02}", i, j);
                let mut flag = true;
                for (ch1, ch2) in s.chars().zip(time.chars()) {
                    if ch2 != '?' && ch1 != ch2 {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    count += 1;
                }
            }
        }
        count
    }
}