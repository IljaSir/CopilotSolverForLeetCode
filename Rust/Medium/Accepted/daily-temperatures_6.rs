impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; temperatures.len()];
        let mut stack = Vec::new();
        for (i, &temp) in temperatures.iter().enumerate() {
            while let Some(&j) = stack.last() {
                if temperatures[j] < temp {
                    res[j] = (i - j) as i32;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        res
    }
}