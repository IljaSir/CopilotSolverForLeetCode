impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for a in answers {
            *map.entry(a).or_insert(0) += 1;
        }
        for (k, v) in map {
            res += (v + k) / (k + 1) * (k + 1);
        }
        res
    }
}