impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut result = Vec::new();
        for op in operations {
            match op.as_str() {
                "+" => {
                    let last = result.pop().unwrap();
                    let second_last = result.pop().unwrap();
                    result.push(second_last);
                    result.push(last);
                    result.push(last + second_last);
                }
                "D" => {
                    let last = result.pop().unwrap();
                    result.push(last);
                    result.push(last * 2);
                }
                "C" => {
                    result.pop();
                }
                _ => {
                    result.push(op.parse::<i32>().unwrap());
                }
            }
        }
        result.iter().sum()
    }
}