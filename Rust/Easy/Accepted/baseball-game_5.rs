impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores: Vec<i32> = Vec::new();
        for op in operations {
            match op.as_str() {
                "C" => {
                    scores.pop();
                },
                "D" => {
                    let last = scores.last().unwrap();
                    scores.push(last * 2);
                },
                "+" => {
                    let last = scores.last().unwrap();
                    let last2 = scores[scores.len() - 2];
                    scores.push(last + last2);
                },
                _ => {
                    let score = op.parse::<i32>().unwrap();
                    scores.push(score);
                }
            }
        }
        scores.iter().sum()
    }
}