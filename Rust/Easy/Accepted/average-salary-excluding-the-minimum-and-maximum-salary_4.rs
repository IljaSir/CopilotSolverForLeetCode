impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut salary = salary;
        salary.sort();
        let mut sum = 0;
        for i in 1..salary.len()-1 {
            sum += salary[i];
        }
        sum as f64 / (salary.len() - 2) as f64
    }
}