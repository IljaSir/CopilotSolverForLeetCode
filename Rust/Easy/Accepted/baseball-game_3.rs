impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores: Vec<i32> = Vec::new();
        for op in operations {
            match op.as_str() {
                "C" => {
                    scores.pop();
                }
                "D" => {
                    if let Some(&score) = scores.last() {
                        scores.push(score * 2);
                    }
                }
                "+" => {
                    if let Some(&score1) = scores.last() {
                        if let Some(&score2) = scores.get(scores.len() - 2) {
                            scores.push(score1 + score2);
                        }
                    }
                }
                _ => {
                    scores.push(op.parse::<i32>().unwrap());
                }
            }
        }
        scores.iter().sum()
    }
}