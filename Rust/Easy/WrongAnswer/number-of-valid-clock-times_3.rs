impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        let mut time = time.chars().collect::<Vec<_>>();
        for i in 0..time.len() {
            if time[i] == '?' {
                if i == 0 {
                    if time[1] == '?' || time[1] <= '3' {
                        count += 24;
                    } else {
                        count += 4;
                    }
                } else if i == 1 {
                    if time[0] == '?' || time[0] == '2' {
                        count += 10;
                    } else {
                        count += 4;
                    }
                } else if i == 3 {
                    count += 6;
                } else {
                    count += 10;
                }
            }
        }
        count
    }
}