impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut count = 0;
        let mut c: Vec<&str> = current.split(':').collect();
        let mut co: Vec<&str> = correct.split(':').collect();
        let mut c1: i32 = c[0].parse::<i32>().unwrap();
        let mut c2: i32 = c[1].parse::<i32>().unwrap();
        let mut co1: i32 = co[0].parse::<i32>().unwrap();
        let mut co2: i32 = co[1].parse::<i32>().unwrap();
        if c1 < co1 {
            while c1 < co1 {
                if c2 <= co2 {
                    c2 += 60;
                    count += 1;
                }
                if c2 > co2 {
                    c2 -= 60;
                    c1 += 1;
                    count += 1;
                }
            }
        } else if c1 > co1 {
            while c1 > co1 {
                if c2 >= co2 {
                    c2 -= 60;
                    count += 1;
                }
                if c2 < co2 {
                    c2 += 60;
                    c1 -= 1;
                    count += 1;
                }
            }
        }
        if c2 < co2 {
            while c2 < co2 {
                if co2 - c2 >= 15 {
                    c2 += 15;
                    count += 1;
                } else if co2 - c2 >= 5 {
                    c2 += 5;
                    count += 1;
                } else if co2 - c2 >= 1 {
                    c2 += 1;
                    count += 1;
                }
            }
        } else if c2 > co2 {
            while c2 > co2 {
                if c2 - co2 >= 15 {
                    c2 -= 15;
                    count += 1;
                } else if c2 - co2 >= 5 {
                    c2 -= 5;
                    count += 1;
                } else if c2 - co2 >= 1 {
                    c2 -= 1;
                    count += 1;
                }
            }
        }
        count
    }
}