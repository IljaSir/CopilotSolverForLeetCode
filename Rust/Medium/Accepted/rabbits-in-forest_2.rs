impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut count = std::collections::HashMap::new();
        for &a in answers.iter() {
            *count.entry(a).or_insert(0) += 1;
        }
        let mut result = 0;
        for (k, v) in count {
            let n = (v + k) / (k + 1) * (k + 1);
            result += n;
        }
        result
    }
}