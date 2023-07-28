impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores: Vec<i32> = Vec::new();
        for op in operations {
            match op.as_str() {
                "C" => {
                    scores.pop();
                }
                "D" => {
                    scores.push(scores.last().unwrap() * 2);
                }
                "+" => {
                    let n = scores.len();
                    scores.push(scores[n - 1] + scores[n - 2]);
                }
                _ => {
                    scores.push(op.parse::<i32>().unwrap());
                }
            }
        }
        scores.iter().sum()
    }
}