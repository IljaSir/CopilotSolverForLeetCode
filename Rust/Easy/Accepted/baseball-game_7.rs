impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut stack = Vec::new();
        for op in operations {
            match op.as_str() {
                "+" => {
                    let a = stack.pop().unwrap();
                    let b = stack.pop().unwrap();
                    let sum = a + b;
                    stack.push(b);
                    stack.push(a);
                    stack.push(sum);
                },
                "D" => {
                    let a = stack.pop().unwrap();
                    let sum = a * 2;
                    stack.push(a);
                    stack.push(sum);
                },
                "C" => {
                    stack.pop();
                },
                _ => {
                    stack.push(op.parse::<i32>().unwrap());
                },
            }
        }
        stack.iter().sum()
    }
}