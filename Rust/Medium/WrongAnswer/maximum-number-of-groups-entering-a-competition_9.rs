impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut groups = 0;
        let mut sum = 0;
        let mut count = 0;
        let mut last = 0;
        for g in grades.iter().rev() {
            if *g != last {
                if sum > 0 && count > 0 && sum < count {
                    groups += 1;
                }
                sum = *g;
                count = 1;
                last = *g;
            } else {
                sum += *g;
                count += 1;
            }
        }
        if sum > 0 && count > 0 && sum < count {
            groups += 1;
        }
        groups
    }
}