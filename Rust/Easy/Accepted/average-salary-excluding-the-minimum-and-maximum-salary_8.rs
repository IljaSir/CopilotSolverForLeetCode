impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut min = salary[0];
        let mut max = salary[0];
        let mut sum = 0;
        for &s in salary.iter() {
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