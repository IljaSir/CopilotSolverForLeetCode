impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut groups = vec![];
        for grade in grades {
            let mut i = 0;
            while i < groups.len() {
                if groups[i] >= grade {
                    break;
                }
                i += 1;
            }
            if i < groups.len() {
                groups[i] = grade;
            } else {
                groups.push(grade);
            }
        }
        groups.len() as i32
    }
}