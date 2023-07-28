impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut grades = grades;
        grades.sort();
        let (mut i, mut j, mut cnt) = (0, 0, 0);
        while i < grades.len() {
            while j < grades.len() && grades[j] - grades[i] <= 5 {
                j += 1;
            }
            cnt += 1;
            i = j;
        }
        cnt
    }
}