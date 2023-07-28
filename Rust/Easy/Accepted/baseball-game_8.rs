impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        
        let mut stack = Vec::new();
        for item in operations {
            match item.as_str() {
                "C" => {stack.pop();},
                "D" => {stack.push(stack.last().unwrap() * 2);},
                "+" => {stack.push(stack.last().unwrap() + stack[stack.len() - 2]);},
                _ => {stack.push(item.parse::<i32>().unwrap());}
            }
        }
        stack.iter().sum()
    }
}