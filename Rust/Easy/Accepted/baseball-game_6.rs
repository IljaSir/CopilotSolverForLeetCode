impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores: Vec<i32> = Vec::new();
        for op in operations {
            match op.as_str() {
                "C" => { scores.pop(); },
                "D" => { scores.push(2 * scores[scores.len() - 1]); },
                "+" => { scores.push(scores[scores.len() - 1] + scores[scores.len() - 2]); },
                _ => { scores.push(op.parse::<i32>().unwrap()); },
            }
        }
        scores.iter().sum()
    }
}