impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut sum = 0;
        let mut min = salary[0];
        let mut max = salary[0];
        for i in 0..salary.len() {
            sum += salary[i];
            if salary[i] < min {
                min = salary[i];
            }
            if salary[i] > max {
                max = salary[i];
            }
        }
        (sum - min - max) as f64 / (salary.len() - 2) as f64
    }
}