impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut m = std::collections::HashMap::new();
        for ans in answers {
            if ans == 0 {
                res += 1;
                continue;
            }
            let e = m.entry(ans).or_insert(0);
            *e += 1;
            if *e == ans + 1 {
                res += ans + 1;
                *e = 0;
            }
        }
        res
    }
}