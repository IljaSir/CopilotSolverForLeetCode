impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        
        let mut students = students;
        let mut sandwiches = sandwiches;
        let mut count = 0;
        while count < students.len() {
            if students[0] == sandwiches[0] {
                students.remove(0);
                sandwiches.remove(0);
                count = 0;
            } else {
                students.push(students.remove(0));
                count += 1;
            }
        }
        students.len() as i32
    }
}