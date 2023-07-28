impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut grades = grades;
        grades.sort();
        let mut groups = 1;
        let mut sum = 0;
        let mut size = 0;
        for i in 0..grades.len() {
            if sum + grades[i] <= size + 1 {
                sum += grades[i];
                size += 1;
            } else {
                sum = grades[i];
                size = 1;
                groups += 1;
            }
        }
        groups
    }
}