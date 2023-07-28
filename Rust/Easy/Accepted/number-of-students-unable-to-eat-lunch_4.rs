impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        
        let mut students = students;
        let mut sandwiches = sandwiches;
        let mut count = 0;
        while !sandwiches.is_empty() {
            if students[0] == sandwiches[0] {
                students.remove(0);
                sandwiches.remove(0);
                count = 0;
            } else {
                let first = students.remove(0);
                students.push(first);
                count += 1;
                if count == students.len() {
                    break;
                }
            }
        }
        students.len() as i32
    }
}