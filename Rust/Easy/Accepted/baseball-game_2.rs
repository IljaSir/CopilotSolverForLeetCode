impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut scores = vec![];
        for op in operations {
            match op.as_str() {
                "C" => {
                    scores.pop();
                }
                "D" => {
                    scores.push(scores.last().unwrap() * 2);
                }
                "+" => {
                    let last = scores.last().unwrap();
                    let second_last = scores[scores.len() - 2];
                    scores.push(last + second_last);
                }
                _ => {
                    scores.push(op.parse().unwrap());
                }
            }
        }
        scores.iter().sum()
    }
}