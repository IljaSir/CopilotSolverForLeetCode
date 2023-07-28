impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut sum = 0;
        let mut min = salary[0];
        let mut max = salary[0];
        for i in &salary {
            sum += i;
            if *i < min {
                min = *i;
            }
            if *i > max {
                max = *i;
            }
        }
        (sum - min - max) as f64 / (salary.len() - 2) as f64
    }
}