impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut result = 0;
        let mut time = time.chars().collect::<Vec<char>>();
        for h1 in 0..24 {
            for h2 in 0..24 {
                for m1 in 0..60 {
                    for m2 in 0..60 {
                        time[0] = (h1 / 10) as u8 as char;
                        time[1] = (h1 % 10) as u8 as char;
                        time[3] = (m1 / 10) as u8 as char;
                        time[4] = (m1 % 10) as u8 as char;
                        if time[0] == '?' || time[1] == '?' || time[3] == '?' || time[4] == '?' {
                            continue;
                        }
                        let hour = (time[0] as u8 - 48) * 10 + (time[1] as u8 - 48);
                        let minute = (time[3] as u8 - 48) * 10 + (time[4] as u8 - 48);
                        if hour < 24 && minute < 60 {
                            result += 1;
                        }
                    }
                }
            }
        }
        result
    }
}