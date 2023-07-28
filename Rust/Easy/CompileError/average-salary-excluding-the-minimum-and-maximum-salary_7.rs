impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let (mut min, mut max, mut sum) = (salary[0], salary[0], 0);
        for s in salary {
            if s < min {
                min = s;
            }
            if s > max {
                max = s;
            }
            sum += s;
        }
        (sum - min - max) as f64 / (salary.len() - 2) as f64
    }
}