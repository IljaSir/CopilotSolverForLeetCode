impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        
        let (mut o, mut z) = (0,0);
        for s in students {
            if s == 0 { z += 1; } else { o += 1; }
        }
        let mut i = 0;
        while i < sandwiches.len() {
            if sandwiches[i] == 0 {
                if z == 0 { break; }
                z -= 1;
            } else {
                if o == 0 { break; }
                o -= 1;
            }
            i += 1;
        }
        (students.len() - i) as i32
    }
}