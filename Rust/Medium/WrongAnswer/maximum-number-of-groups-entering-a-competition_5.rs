impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut grades = grades;
        grades.sort();
        let mut groups = 0;
        let mut i = 0;
        let mut j = 0;
        while i < grades.len() {
            let mut sum = 0;
            let mut count = 0;
            while j < grades.len() && sum < grades[j] {
                sum += grades[j];
                count += 1;
                j += 1;
            }
            if count > 1 {
                groups += 1;
            }
            i = j;
        }
        groups
    }
}