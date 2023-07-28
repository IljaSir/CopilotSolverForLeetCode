impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut sum = 0;
        let mut max = salary[0];
        let mut min = salary[0];
        for i in salary {
            sum += i;
            if i > max {
                max = i;
            }
            if i < min {
                min = i;
            }
        }
        (sum - max - min) as f64 / (salary.len() - 2) as f64
    }
}