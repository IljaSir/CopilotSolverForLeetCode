impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        
        let mut students = students;
        let mut sandwiches = sandwiches;
        let mut count = 0;
        'outer: loop {
            for i in 0..students.len() {
                if students[i] == sandwiches[0] {
                    students.remove(i);
                    sandwiches.remove(0);
                    count = 0;
                    continue 'outer;
                }
            }
            count += 1;
            if count == students.len() {
                break;
            }
        }
        students.len() as i32
    }
}