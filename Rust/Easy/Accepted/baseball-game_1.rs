impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores = vec![];
        for op in operations {
            match op.as_str() {
                "C" => { scores.pop(); },
                "D" => { scores.push(scores.last().unwrap() * 2); },
                "+" => { scores.push(scores.last().unwrap() + scores[scores.len() - 2]); },
                _ => { scores.push(op.parse::<i32>().unwrap()); },
            }
        }
        scores.iter().sum()
    }
}