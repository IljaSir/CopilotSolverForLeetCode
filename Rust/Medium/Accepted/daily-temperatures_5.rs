impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut res = vec![0; temperatures.len()];
        for i in 0..temperatures.len() {
            while stack.len() > 0 && temperatures[i] > temperatures[stack[stack.len() - 1]] {
                let top = stack.pop().unwrap();
                res[top] = (i - top) as i32;
            }
            stack.push(i);
        }
        res
    }
}