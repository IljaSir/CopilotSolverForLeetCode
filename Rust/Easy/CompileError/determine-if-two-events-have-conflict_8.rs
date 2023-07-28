impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let mut time1 = vec![0; 24 * 60];
        let mut time2 = vec![0; 24 * 60];
        let mut time1_start = 0;
        let mut time2_start = 0;
        for i in 0..event1.len() {
            let mut time = 0;
            for c in event1[i].chars() {
                if c == ':' {
                    time *= 60;
                } else {
                    time = time * 10 + (c as u8 - '0' as u8) as i32;
                }
            }
            if i == 0 {
                time1_start = time;
            } else {
                time1[time] = 1;
            }
        }
        for i in 0..event2.len() {
            let mut time = 0;
            for c in event2[i].chars() {
                if c == ':' {
                    time *= 60;
                } else {
                    time = time * 10 + (c as u8 - '0' as u8) as i32;
                }
            }
            if i == 0 {
                time2_start = time;
            } else {
                time2[time] = 1;
            }
        }
        if time1_start < time2_start {
            for i in time1_start..time2_start {
                if time1[i] == 1 {
                    return true;
                }
            }
        } else {
            for i in time2_start..time1_start {
                if time2[i] == 1 {
                    return true;
                }
            }
        }
        false
    }
}