impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        for i in 0..=23 {
            for j in 0..=59 {
                let mut t = format!("{:02}:{:02}", i, j);
                let mut flag = true;
                for (k, c) in t.chars().enumerate() {
                    if c != time.chars().nth(k).unwrap() && time.chars().nth(k).unwrap() != '?' {
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