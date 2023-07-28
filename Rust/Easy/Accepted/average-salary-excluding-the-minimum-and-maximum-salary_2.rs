impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut max = salary[0];
        let mut min = salary[0];
        let mut sum = salary[0];
        for i in 1..salary.len() {
            if salary[i] > max {
                max = salary[i];
            }
            if salary[i] < min {
                min = salary[i];
            }
            sum += salary[i];
        }
        (sum - max - min) as f64 / (salary.len() - 2) as f64
    }
}