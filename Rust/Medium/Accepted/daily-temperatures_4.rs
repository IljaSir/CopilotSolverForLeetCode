impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut res = vec![0; temperatures.len()];
        for i in 0..temperatures.len() {
            while let Some(&j) = stack.last() {
                if temperatures[j] >= temperatures[i] {
                    break;
                }
                stack.pop();
                res[j] = (i - j) as i32;
            }
            stack.push(i);
        }
        res
    }
}