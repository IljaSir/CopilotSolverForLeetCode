impl Solution {
    pub fn good_days_to_rob_bank(security: Vec<i32>, time: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut max = -1;
        let mut min = -1;
        let mut max_index = -1;
        let mut min_index = -1;
        let time = time as usize;
        for i in 0..security.len() {
            if i >= time {
                if security[i - time] > max {
                    max = security[i - time];
                    max_index = i as i32 - time as i32;
                }
                if security[i - time] < min {
                    min = security[i - time];
                    min_index = i as i32 - time as i32;
                }
            }
            if i >= time * 2 {
                if max_index == i as i32 - time as i32 * 2 {
                    max = -1;
                    max_index = -1;
                }
                if min_index == i as i32 - time as i32 * 2 {
                    min = -1;
                    min_index = -1;
                }
            }
            if i >= time - 1 {
                if max == -1 {
                    for j in i - time + 1..i + 1 {
                        if security[j] > max {
                            max = security[j];
                        }
                    }
                }
                if min == -1 {
                    for j in i - time + 1..i + 1 {
                        if security[j] < min {
                            min = security[j];
                        }
                    }
                }
                if security[i] >= max && security[i] <= min {
                    result.push(i as i32);
                }
            }
        }
        result
    }
}