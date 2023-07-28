impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for answer in answers {
            if let Some(&v) = map.get(&answer) {
                if v > 0 {
                    map.insert(answer, v - 1);
                } else {
                    map.insert(answer, answer);
                    res += answer + 1;
                }
            } else {
                map.insert(answer, answer);
                res += answer + 1;
            }
        }
        res
    }
}