impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for ans in answers {
            if ans == 0 {
                count += 1;
            } else {
                let count = map.entry(ans).or_insert(0);
                *count += 1;
                if *count > ans {
                    *count = 1;
                    count += ans + 1;
                }
            }
        }
        count
    }
}